package com.ajsoftware.fintrack.features.reports.presentation.mapper

import com.ajsoftware.fintrack.features.reports.domain.model.CategoryExpense
import com.ajsoftware.fintrack.features.reports.presentation.model.CategoryExpenseUi

fun CategoryExpense.toUi(): CategoryExpenseUi {
    return CategoryExpenseUi(
        categoryName = categoryName,
        amount = total,
        color = color
    )
}