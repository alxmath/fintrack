package com.ajsoftware.fintrack.features.reports.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajsoftware.fintrack.features.reports.domain.usecase.GetExpensesByCategoryUseCase
import com.ajsoftware.fintrack.features.reports.presentation.mapper.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ReportsViewModel @Inject constructor(
    getExpensesByCategoryUseCase: GetExpensesByCategoryUseCase
) : ViewModel() {

    val expensesByCategory = getExpensesByCategoryUseCase()
        .map { list -> list.map { it.toUi() } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
}