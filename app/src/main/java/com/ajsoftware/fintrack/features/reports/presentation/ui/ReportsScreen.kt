package com.ajsoftware.fintrack.features.reports.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajsoftware.fintrack.core.ui.components.FinTrackSectionTitle

@Composable
fun ReportsScreen() {

    Scaffold { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            FinTrackSectionTitle("Relatórios")

            // conteúdo virá nos próximos passos

        }
    }
}