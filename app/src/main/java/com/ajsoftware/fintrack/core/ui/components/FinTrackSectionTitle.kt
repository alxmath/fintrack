package com.ajsoftware.fintrack.core.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FinTrackSectionTitle(text: String) {

    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium
    )

}