package com.ajsoftware.fintrack.features.categories.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.FilterChip
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
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
    var selectedColor by remember { mutableStateOf(Color(0xFF64B5F6)) }
    var selectedIcon by remember { mutableStateOf("food") }

    val isValid = name.isNotBlank()

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

            Spacer(modifier = Modifier.height(20.dp))

            // NOME
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nome da categoria") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            // TIPO
            Text(
                text = "Tipo",
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                FilterChip(
                    selected = type == CategoryType.EXPENSE,
                    onClick = { type = CategoryType.EXPENSE },
                    label = { Text("Despesa") }
                )

                FilterChip(
                    selected = type == CategoryType.INCOME,
                    onClick = { type = CategoryType.INCOME },
                    label = { Text("Receita") }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ÍCONE
            Text(
                text = "Ícone",
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            CategoryIconPicker(
                onIconSelected = {
                    selectedIcon = it.name
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // COR
            Text(
                text = "Cor",
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            CategoryColorPicker(
                selectedColor = selectedColor,
                onColorSelected = {
                    selectedColor = it
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            // BOTÃO SALVAR
            Button(
                onClick = {
                    if (isValid) {
                        onSave(
                            Category(
                                id = 0,
                                name = name,
                                type = type,
                                icon = selectedIcon,
                                color = selectedColor.toString()
                            )
                        )
                    }
                },
                enabled = isValid,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Salvar")
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}