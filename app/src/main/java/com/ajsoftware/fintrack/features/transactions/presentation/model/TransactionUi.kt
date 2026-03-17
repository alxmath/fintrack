package com.ajsoftware.fintrack.features.transactions.presentation.model

import com.ajsoftware.fintrack.core.model.TransactionType

data class TransactionUi(
    val id: Long,
    val description: String?,
    val amount: Double,
    val categoryName: String,
    val categoryIcon: String?,
    val categoryColor: String?
)