package com.ajsoftware.fintrack.features.reports.domain.usecase

import com.ajsoftware.fintrack.features.reports.domain.repository.ReportsRepository

class GetExpensesByCategoryUseCase(
    private val repository: ReportsRepository
) {

    operator fun invoke() =
        repository.getExpensesByCategory()

}