package com.ajsoftware.fintrack.features.reports.domain.repository

import com.ajsoftware.fintrack.features.reports.domain.model.CategoryExpense
import kotlinx.coroutines.flow.Flow

interface ReportsRepository {

    fun getExpensesByCategory(startDate: Long): Flow<List<CategoryExpense>>
}