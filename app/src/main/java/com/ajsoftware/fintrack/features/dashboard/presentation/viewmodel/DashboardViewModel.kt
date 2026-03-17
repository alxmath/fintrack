package com.ajsoftware.fintrack.features.dashboard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajsoftware.fintrack.features.dashboard.model.FinancialSummaryUi
import com.ajsoftware.fintrack.features.transactions.domain.usecase.GetFinancialSummaryUseCase
import com.ajsoftware.fintrack.features.transactions.domain.usecase.GetTransactionsUseCase
import com.ajsoftware.fintrack.features.transactions.presentation.mapper.toUi
import com.ajsoftware.fintrack.features.transactions.presentation.model.TransactionUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.collections.map

@HiltViewModel
class DashboardViewModel @Inject constructor(
    getFinancialSummaryUseCase: GetFinancialSummaryUseCase,
    getTransactionsUseCase: GetTransactionsUseCase
) : ViewModel() {

    val transactions = getTransactionsUseCase()
        .map { transactions ->

            transactions.map { transaction ->

                TransactionUi(
                    id = transaction.id,
                    description = transaction.description,
                    amount = transaction.amount,
                    categoryName = "Categoria", // temporário
                    categoryIcon = null,
                    categoryColor = null,
                    type = transaction.type,
                    date = transaction.date
                )

            }

        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    val summary: StateFlow<FinancialSummaryUi> =
        getFinancialSummaryUseCase()
            .map { it.toUi() }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Companion.WhileSubscribed(5_000),
                initialValue = FinancialSummaryUi(
                    totalIncome = 0.0,
                    totalExpense = 0.0,
                    balance = 0.0
                )
            )
}