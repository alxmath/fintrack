package com.ajsoftware.fintrack.features.transactions.domain.usecase

import com.ajsoftware.fintrack.core.model.TransactionType
import com.ajsoftware.fintrack.features.transactions.domain.model.MonthlySummary
import com.ajsoftware.fintrack.features.transactions.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetFinancialSummaryUseCase @Inject constructor(
    private val repository: TransactionRepository) {

    operator fun invoke(): Flow<MonthlySummary> {

        val income = repository.getTotalByType(TransactionType.INCOME)
        val expense = repository.getTotalByType(TransactionType.EXPENSE)

        return combine(income, expense) { inc, exp ->

            val totalIncome = inc ?: 0.0
            val totalExpense = exp ?: 0.0

            MonthlySummary(
                totalIncome = totalIncome,
                totalExpense = totalExpense,
                balance = totalIncome - totalExpense
            )
        }
    }

}