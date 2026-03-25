package com.ajsoftware.fintrack.features.reports.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajsoftware.fintrack.features.reports.domain.model.ReportPeriod
import com.ajsoftware.fintrack.features.reports.domain.usecase.GetExpensesByCategoryUseCase
import com.ajsoftware.fintrack.features.reports.presentation.mapper.toUi
import com.ajsoftware.fintrack.features.reports.presentation.model.CategoryExpenseUi
import com.ajsoftware.fintrack.features.reports.presentation.state.ReportsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReportsViewModel @Inject constructor(
    private val getExpensesByCategoryUseCase: GetExpensesByCategoryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ReportsUiState())
    val uiState: StateFlow<ReportsUiState> = _uiState.asStateFlow()

    private val selectedPeriod = MutableStateFlow(ReportPeriod.LAST_30_DAYS)
    val period: StateFlow<ReportPeriod> = selectedPeriod.asStateFlow()



    init {
        viewModelScope.launch {
            expensesByCategory.collect { list ->
                _uiState.update {
                    it.copy(categories = list)
                }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val expensesByCategory: StateFlow<List<CategoryExpenseUi>> =
        selectedPeriod
            .flatMapLatest { period ->

                val startDate = calculateStartDate(period)

                getExpensesByCategoryUseCase(startDate)
                    .map { list -> list.map { it.toUi() } }

            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )

    fun selectPeriod(period: ReportPeriod) {
        selectedPeriod.value = period
    }

    fun selectCategory(category: String?) {
        _uiState.update {
            it.copy(selectedCategory = category)
        }
    }

    private fun calculateStartDate(period: ReportPeriod): Long {
        val now = System.currentTimeMillis()
        val millis = period.days * 24 * 60 * 60 * 1000
        return now - millis
    }
}