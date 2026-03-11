package com.ajsoftware.fintrack.features.transactions.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction
import com.ajsoftware.fintrack.features.transactions.domain.usecase.AddTransactionUseCase
import com.ajsoftware.fintrack.features.transactions.domain.usecase.DeleteTransactionUseCase
import com.ajsoftware.fintrack.features.transactions.domain.usecase.GetTransactionsUseCase
import com.ajsoftware.fintrack.features.transactions.presentation.state.TransactionsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val addTransaction: AddTransactionUseCase,
    private val getTransactions: GetTransactionsUseCase,
    private val deleteTransaction: DeleteTransactionUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(TransactionsState())
    val state: StateFlow<TransactionsState> = _state.asStateFlow()

    init {
        loadTransactions()
    }

    fun loadTransactions() {
        viewModelScope.launch {

            _state.value = _state.value.copy(isLoading = true)

            val transactions = getTransactions()

            _state.value = _state.value.copy(
                transactions = transactions,
                isLoading = false
            )
        }
    }

    fun add(transaction: Transaction){
        viewModelScope.launch {
            addTransaction(transaction)
            loadTransactions()
        }
    }

    fun delete(transaction: Transaction) {
        viewModelScope.launch {
            deleteTransaction(transaction)
            loadTransactions()
        }
    }
}