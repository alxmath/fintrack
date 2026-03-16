package com.ajsoftware.fintrack.features.reports.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajsoftware.fintrack.core.ui.components.FinTrackSectionTitle
import com.ajsoftware.fintrack.core.ui.components.FinTrackSpacer
import com.ajsoftware.fintrack.core.utils.formatCurrency
import com.ajsoftware.fintrack.features.reports.presentation.viewmodel.ReportsViewModel

@Composable
fun ReportsScreen(
    viewModel: ReportsViewModel = hiltViewModel()
) {

    val expenses by viewModel.expensesByCategory.collectAsState()

    Scaffold { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            FinTrackSectionTitle("Relatórios")

            FinTrackSpacer()

            expenses.forEach {

                Text("${it.categoryName}: ${formatCurrency(it.total)}")

            }

        }

    }
}