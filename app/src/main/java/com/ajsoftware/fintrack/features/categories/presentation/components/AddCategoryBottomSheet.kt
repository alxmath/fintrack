package com.ajsoftware.fintrack.features.categories.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajsoftware.fintrack.core.model.CategoryType
import com.ajsoftware.fintrack.features.categories.domain.model.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCategoryBottomSheet(
    onDismiss: () -> Unit,
    onSave: (Category) -> Unit
) {

    var name by remember { mutableStateOf("") }
    var type by remember { mutableStateOf(CategoryType.EXPENSE) }

    ModalBottomSheet(
        onDismissRequest = onDismiss
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {

            Text(
                text = "Nova Categoria",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nome da categoria") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {

                FilterChip(
                    selected = type == CategoryType.EXPENSE,
                    onClick = { type = CategoryType.EXPENSE },
                    label = { Text("Despesa") }
                )

                Spacer(modifier = Modifier.width(8.dp))

                FilterChip(
                    selected = type == CategoryType.INCOME,
                    onClick = { type = CategoryType.INCOME },
                    label = { Text("Receita") }
                )

            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (name.isNotBlank()) {

                        onSave(
                            Category(
                                id = 0,
                                name = name,
                                type = type
                            )
                        )

                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Salvar")
            }

            Spacer(modifier = Modifier.height(16.dp))

        }

    }
}