package com.ajsoftware.fintrack.features.transactions.presentation.state

import com.ajsoftware.fintrack.core.model.TransactionType

data class AddTransactionState(
    val amount: String = "",
    val description: String = "",
    val selectedType: TransactionType = TransactionType.EXPENSE,
    val selectedCategoryId: Long? = null,
    val error: String? = null
)