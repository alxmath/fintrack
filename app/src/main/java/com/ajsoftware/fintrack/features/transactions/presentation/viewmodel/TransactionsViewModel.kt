package com.ajsoftware.fintrack.features.transactions.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction
import com.ajsoftware.fintrack.features.transactions.domain.usecase.AddTransactionUseCase
import com.ajsoftware.fintrack.features.transactions.domain.usecase.DeleteTransactionUseCase
import com.ajsoftware.fintrack.features.transactions.domain.usecase.GetTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
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
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
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