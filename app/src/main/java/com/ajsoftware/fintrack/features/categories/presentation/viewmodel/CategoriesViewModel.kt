package com.ajsoftware.fintrack.features.categories.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajsoftware.fintrack.features.categories.domain.model.Category
import com.ajsoftware.fintrack.features.categories.domain.usecase.AddCategoryUseCase
import com.ajsoftware.fintrack.features.categories.domain.usecase.DeleteCategoryUseCase
import com.ajsoftware.fintrack.features.categories.domain.usecase.GetCategoriesUseCase
import com.ajsoftware.fintrack.features.categories.presentation.state.CategoriesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    getCategoriesUseCase: GetCategoriesUseCase,
    private val addCategoryUseCase: AddCategoryUseCase,
    private val deleteCategoryUseCase: DeleteCategoryUseCase
) : ViewModel() {

    val uiState: StateFlow<CategoriesUiState> =
        getCategoriesUseCase()
            .map { categories ->
                CategoriesUiState(
                    categories = categories,
                    isLoading = false
                )
            }
            .catch { throwable ->
                emit(
                    CategoriesUiState(
                        error = throwable.message ?: "Erro ao carregar categorias"
                    )
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = CategoriesUiState(isLoading = true)
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