package com.ajsoftware.fintrack.features.transactions.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ajsoftware.fintrack.core.utils.formatCurrency

@Composable
fun SummaryItem(
    label: String,
    value: Double,
    color: Color
) {

    Column {

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = formatCurrency(value),
            color = color,
            style = MaterialTheme.typography.titleMedium
        )
    }
}