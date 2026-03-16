package com.ajsoftware.fintrack.features.categories.presentation.state

import com.ajsoftware.fintrack.features.categories.domain.model.Category

data class CategoriesUiState(
    val categories: List<Category> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)