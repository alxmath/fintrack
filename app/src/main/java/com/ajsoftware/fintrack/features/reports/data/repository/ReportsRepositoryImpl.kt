package com.ajsoftware.fintrack.features.reports.data.repository

import com.ajsoftware.fintrack.core.database.dao.TransactionDao
import com.ajsoftware.fintrack.features.reports.domain.repository.ReportsRepository
import javax.inject.Inject

class ReportsRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao
) : ReportsRepository {

    override fun getExpensesByCategory() =
        transactionDao.getExpensesByCategory()

}