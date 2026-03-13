package com.ajsoftware.fintrack.features.transactions.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajsoftware.fintrack.features.dashboard.model.FinancialSummaryUi
import com.ajsoftware.fintrack.features.transactions.domain.usecase.GetFinancialSummaryUseCase
import com.ajsoftware.fintrack.features.transactions.presentation.mapper.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    getFinancialSummaryUseCase: GetFinancialSummaryUseCase
) : ViewModel() {

    val summary: StateFlow<FinancialSummaryUi> =
        getFinancialSummaryUseCase()
            .map { it.toUi() }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = FinancialSummaryUi(
                    totalIncome = 0.0,
                    totalExpense = 0.0,
                    balance = 0.0
                )
            )
}