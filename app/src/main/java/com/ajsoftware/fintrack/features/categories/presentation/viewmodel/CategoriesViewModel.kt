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
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val addCategoryUseCase: AddCategoryUseCase,
    private val deleteCategoryUseCase: DeleteCategoryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CategoriesUiState(isLoading = true))
    val uiState: StateFlow<CategoriesUiState> = _uiState.asStateFlow()

    init {
        observeCategories()
    }

    private fun observeCategories() {
        getCategoriesUseCase()
            .onEach { categories ->
                _uiState.update {
                    it.copy(
                        categories = categories,
                        isLoading = false,
                        error = null
                    )
                }
            }
            .catch { throwable ->
                _uiState.update { state ->
                    state.copy(
                        isLoading = false,
                        error = throwable.message ?: "Erro ao carregar categorias"
                    )
                }
            }
            .launchIn(viewModelScope)
    }

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