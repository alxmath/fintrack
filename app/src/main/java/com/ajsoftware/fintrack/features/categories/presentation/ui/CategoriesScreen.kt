package com.ajsoftware.fintrack.features.categories.presentation.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajsoftware.fintrack.features.categories.presentation.components.CategoryItem
import com.ajsoftware.fintrack.features.categories.presentation.viewmodel.CategoriesViewModel

@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    var showSheet by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showSheet = true }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Nova categoria")
            }
        }
    ) { padding ->

        LazyColumn(
            contentPadding = padding
        ) {

            items(
                items = state.categories,
                key = { it.id }
            ) { category ->

                CategoryItem(
                    category = category,
                    onDelete = { viewModel.deleteCategory(it) }
                )

            }

        }
    }

    if (showSheet) {
        AddCategoryBottomSheet(
            onDismiss = { showSheet = false },
            onSave = { category ->
                viewModel.addCategory(category)
                showSheet = false
            }
        )
    }
}