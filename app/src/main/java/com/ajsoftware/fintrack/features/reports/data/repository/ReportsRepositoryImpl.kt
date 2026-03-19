package com.ajsoftware.fintrack.features.reports.data.repository

import com.ajsoftware.fintrack.core.database.dao.TransactionDao
import com.ajsoftware.fintrack.features.reports.domain.model.CategoryExpense
import com.ajsoftware.fintrack.features.reports.domain.repository.ReportsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReportsRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao
) : ReportsRepository {

    override fun getExpensesByCategory(startDate: Long): Flow<List<CategoryExpense>> {
        return transactionDao.getExpensesByCategory(startDate)
    }

}