package com.ajsoftware.fintrack.features.categories.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.LocalGasStation
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class CategoryIcon(
    val name: String,
    val icon: ImageVector
)

@Composable
fun CategoryIconPicker(
    onIconSelected: (CategoryIcon) -> Unit
) {

    val icons = listOf(
        CategoryIcon("food", Icons.Default.Fastfood),
        CategoryIcon("fuel", Icons.Default.LocalGasStation),
        CategoryIcon("entertainment", Icons.Default.Movie),
        CategoryIcon("salary", Icons.Default.Savings)
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        icons.forEach { categoryIcon ->

            IconButton(
                onClick = {
                    onIconSelected(categoryIcon)
                }
            ) {

                Icon(
                    imageVector = categoryIcon.icon,
                    contentDescription = categoryIcon.name
                )

            }

        }

    }
}