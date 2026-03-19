package com.ajsoftware.fintrack.features.reports.domain.usecase

import com.ajsoftware.fintrack.features.reports.domain.model.CategoryExpense
import com.ajsoftware.fintrack.features.reports.domain.repository.ReportsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetExpensesByCategoryUseCase @Inject constructor(
    private val repository: ReportsRepository
) {

    operator fun invoke(startDate: Long): Flow<List<CategoryExpense>> {
        return repository.getExpensesByCategory(startDate)
    }

}