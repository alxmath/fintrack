package com.ajsoftware.fintrack.features.transactions.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajsoftware.fintrack.core.model.TransactionType
import com.ajsoftware.fintrack.features.categories.domain.usecase.GetCategoriesUseCase
import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction
import com.ajsoftware.fintrack.features.transactions.domain.usecase.AddTransactionUseCase
import com.ajsoftware.fintrack.features.transactions.presentation.state.AddTransactionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTransactionViewModel @Inject constructor(
    private val addTransactionUseCase: AddTransactionUseCase,
    getCategoriesUseCase: GetCategoriesUseCase) : ViewModel() {

    private val _state = MutableStateFlow(AddTransactionState())
    val state: StateFlow<AddTransactionState> = _state

    val categories = getCategoriesUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun updateAmount(value: String) {
        _state.value = _state.value.copy(amount = value)
    }

    fun updateDescription(value: String) {
        _state.value = _state.value.copy(description = value)
    }

    fun updateType(type: TransactionType) {
        _state.value = _state.value.copy(selectedType = type)
    }

    fun updateCategory(categoryId: Long) {
        _state.value = _state.value.copy(selectedCategoryId = categoryId)
    }

    fun save() {

        val state = _state.value

        val categoryId = state.selectedCategoryId ?: return

        val amount = state.amount.toDoubleOrNull() ?: return

        val transaction = Transaction(
            id = 0,
            amount = amount,
            description = state.description,
            categoryId = categoryId,
            type = state.selectedType,
            date = System.currentTimeMillis()
        )

        viewModelScope.launch {
            addTransactionUseCase(transaction)
        }
    }
}