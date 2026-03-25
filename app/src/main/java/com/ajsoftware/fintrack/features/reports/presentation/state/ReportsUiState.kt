package com.ajsoftware.fintrack.features.reports.presentation.state

import com.ajsoftware.fintrack.features.reports.domain.model.CategoryExpense
import com.ajsoftware.fintrack.features.reports.presentation.model.CategoryExpenseUi

data class ReportsUiState(
    val isLoading: Boolean = false,
    val categories: List<CategoryExpenseUi> = emptyList(),
    val selectedCategory: String? = null
)