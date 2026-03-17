package com.ajsoftware.fintrack.features.categories.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryColorPicker(
    selectedColor: Color,
    onColorSelected: (Color) -> Unit
) {

    val colors = listOf(
        Color(0xFFE57373),
        Color(0xFF64B5F6),
        Color(0xFF81C784),
        Color(0xFFFFB74D),
        Color(0xFFBA68C8),
        Color(0xFFFF8A65)
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        colors.forEach { color ->

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(color, CircleShape)
                    .clickable {
                        onColorSelected(color)
                    }
            )

        }

    }
}