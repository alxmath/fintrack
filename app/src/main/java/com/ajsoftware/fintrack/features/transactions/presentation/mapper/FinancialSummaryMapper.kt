package com.ajsoftware.fintrack.features.transactions.presentation.mapper

import com.ajsoftware.fintrack.features.dashboard.model.FinancialSummaryUi
import com.ajsoftware.fintrack.features.transactions.domain.model.FinancialSummary

fun FinancialSummary.toUi(): FinancialSummaryUi {
    return FinancialSummaryUi(
        totalIncome = totalIncome,
        totalExpense = totalExpense,
        balance = balance
    )
}