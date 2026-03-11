package com.ajsoftware.fintrack.features.transactions.presentation.state

import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction

data class TransactionsState(
    val transactions: List<Transaction> = emptyList(),
    val isLoading: Boolean = false
)