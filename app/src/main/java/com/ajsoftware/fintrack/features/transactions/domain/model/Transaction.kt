package com.ajsoftware.fintrack.features.transactions.domain.model

data class Transaction(
    val id: Long,
    val amount: Double,
    val description: String?,
    val categoryId: Long,
    val type: String,
    val date: Long
)