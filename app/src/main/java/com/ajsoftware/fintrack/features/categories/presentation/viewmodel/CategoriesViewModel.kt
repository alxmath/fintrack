package com.ajsoftware.fintrack.features.categories.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajsoftware.fintrack.features.categories.domain.model.Category
import com.ajsoftware.fintrack.features.categories.domain.usecase.AddCategoryUseCase
import com.ajsoftware.fintrack.features.categories.domain.usecase.DeleteCategoryUseCase
import com.ajsoftware.fintrack.features.categories.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val addCategoryUseCase: AddCategoryUseCase,
    private val deleteCategoryUseCase: DeleteCategoryUseCase
) : ViewModel() {

    val categories: StateFlow<List<Category>> =
        getCategoriesUseCase()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    fun addCategory(category: Category) {
        viewModelScope.launch {
            addCategoryUseCase(category)
        }
    }

    fun deleteCategory(category: Category) {
        viewModelScope.launch {
            deleteCategoryUseCase(category)
        }
    }
}