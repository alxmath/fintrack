package com.ajsoftware.fintrack.features.transactions.domain.model

import com.ajsoftware.fintrack.core.model.TransactionType

data class Transaction(
    val id: Long,
    val amount: Double,
    val description: String?,
    val categoryId: Long,
    val type: TransactionType,
    val date: Long
)