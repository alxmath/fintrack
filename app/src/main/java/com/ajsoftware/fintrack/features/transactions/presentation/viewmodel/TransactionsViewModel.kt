package com.ajsoftware.fintrack.features.transactions.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction
import com.ajsoftware.fintrack.features.transactions.domain.usecase.AddTransactionUseCase
import com.ajsoftware.fintrack.features.transactions.domain.usecase.DeleteTransactionUseCase
import com.ajsoftware.fintrack.features.transactions.domain.usecase.GetTransactionsUseCase
import com.ajsoftware.fintrack.features.transactions.presentation.model.TransactionUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val addTransaction: AddTransactionUseCase,
    getTransactions: GetTransactionsUseCase,
    private val deleteTransaction: DeleteTransactionUseCase
) : ViewModel() {

    val transactions = getTransactions()
        .map { transactions ->

            transactions.map { transaction ->

                TransactionUi(
                    id = transaction.id,
                    description = transaction.description,
                    amount = transaction.amount,
                    categoryName = "Categoria", // temporário
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

    fun add(transaction: Transaction){
        viewModelScope.launch {
            addTransaction(transaction)
        }
    }

    fun delete(transaction: Transaction) {
        viewModelScope.launch {
            deleteTransaction(transaction)
        }
    }
}