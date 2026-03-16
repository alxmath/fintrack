package com.ajsoftware.fintrack.features.reports.data.repository

import com.ajsoftware.fintrack.core.database.dao.TransactionDao
import com.ajsoftware.fintrack.features.reports.domain.repository.ReportsRepository

class ReportsRepositoryImpl(
    private val transactionDao: TransactionDao
) : ReportsRepository {

    override fun getExpensesByCategory() =
        transactionDao.getExpensesByCategory()

}