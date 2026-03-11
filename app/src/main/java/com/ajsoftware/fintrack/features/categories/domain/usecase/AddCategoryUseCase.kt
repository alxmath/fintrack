package com.ajsoftware.fintrack.features.categories.domain.usecase

import com.ajsoftware.fintrack.features.categories.domain.model.Category
import com.ajsoftware.fintrack.features.categories.domain.repository.CategoryRepository
import javax.inject.Inject

class AddCategoryUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    suspend operator fun invoke(category: Category) {
        repository.insert(category)
    }
}