package com.ajsoftware.fintrack.features.categories.domain.usecase

import com.ajsoftware.fintrack.features.categories.domain.model.Category
import com.ajsoftware.fintrack.features.categories.domain.repository.CategoryRepository
import javax.inject.Inject

class DeleteCategoryUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    suspend operator fun invoke(category: Category) {
        repository.delete(category)
    }
}