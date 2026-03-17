package com.ajsoftware.fintrack.features.transactions.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajsoftware.fintrack.core.model.TransactionType
import com.ajsoftware.fintrack.features.categories.domain.model.Category
import com.ajsoftware.fintrack.features.transactions.presentation.viewmodel.AddTransactionEvent
import com.ajsoftware.fintrack.features.transactions.presentation.viewmodel.AddTransactionViewModel
import androidx.core.graphics.toColorInt

@Composable
fun AddTransactionScreen(
    onTransactionSaved: () -> Unit,
    viewModel: AddTransactionViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()
    val categories by viewModel.categories.collectAsState()

    LaunchedEffect(Unit) {

        viewModel.events.collect { event ->

            when (event) {

                AddTransactionEvent.TransactionSaved -> {
                    onTransactionSaved()
                }

                is AddTransactionEvent.Error -> {
                    // tratar erro
                }
            }
        }
    }

    Scaffold(
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text = "Nova Transação",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            CategoryDropdown(
                categories = categories,
                selectedCategoryId = state.selectedCategoryId,
                onCategorySelected = { viewModel.updateCategory(it) }
            )

            OutlinedTextField(
                value = state.amount,
                onValueChange = { viewModel.updateAmount(it) },
                label = { Text("Valor") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = state.description,
                onValueChange = { viewModel.updateDescription(it) },
                label = { Text("Descrição") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Tipo")

            Row {

                FilterChip(
                    selected = state.selectedType == TransactionType.EXPENSE,
                    onClick = { viewModel.updateType(TransactionType.EXPENSE) },
                    label = { Text("Despesa") }
                )

                Spacer(modifier = Modifier.width(8.dp))

                FilterChip(
                    selected = state.selectedType == TransactionType.INCOME,
                    onClick = { viewModel.updateType(TransactionType.INCOME) },
                    label = { Text("Receita") }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { viewModel.save() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Salvar")
            }

            Spacer(modifier = Modifier.height(8.dp))

            state.error?.let {

                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error
                )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDropdown(
    categories: List<Category>,
    selectedCategoryId: Long?,
    onCategorySelected: (Long) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    val selectedCategory = categories.find { it.id == selectedCategoryId }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {

        OutlinedTextField(
            value = selectedCategory?.name ?: "Selecionar categoria",
            onValueChange = {},
            readOnly = true,
            label = { Text("Categoria") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded)
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {

            categories.forEach { category ->

                DropdownMenuItem(
                    text = {

                        Row {

                            CategoryColorDot(category.color)

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(category.name)

                        }

                    },
                    onClick = {
                        onCategorySelected(category.id)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun CategoryColorDot(colorString: String?) {

    val color = try {
        Color((colorString ?: "#2196F3").toColorInt())
    } catch (e: Exception) {
        Color(0xFF2196F3)
    }

    Box(
        modifier = Modifier
            .size(12.dp)
            .background(color, CircleShape)
    )
}
