package com.ajsoftware.fintrack.features.transactions.domain.model

data class FinancialSummary(
    val totalIncome: Double,
    val totalExpense: Double,
    val balance: Double
)