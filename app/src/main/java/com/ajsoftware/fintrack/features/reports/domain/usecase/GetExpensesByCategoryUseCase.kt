package com.ajsoftware.fintrack.features.reports.domain.usecase

import com.ajsoftware.fintrack.features.reports.domain.repository.ReportsRepository
import javax.inject.Inject

class GetExpensesByCategoryUseCase @Inject constructor(
    private val repository: ReportsRepository
) {

    operator fun invoke() =
        repository.getExpensesByCategory()

}