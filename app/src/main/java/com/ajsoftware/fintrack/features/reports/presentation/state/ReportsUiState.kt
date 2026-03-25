package com.ajsoftware.fintrack.features.reports.presentation.state

import com.ajsoftware.fintrack.features.reports.domain.model.CategoryExpense

data class ReportsUiState(
    val isLoading: Boolean = false,
    val categories: List<CategoryExpense> = emptyList(),
    val selectedCategory: String? = null
)