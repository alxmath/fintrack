package com.ajsoftware.fintrack.features.reports.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajsoftware.fintrack.features.reports.presentation.components.CategoryExpenseLegend
import com.ajsoftware.fintrack.features.reports.presentation.components.CategoryExpensePieChart
import com.ajsoftware.fintrack.features.reports.presentation.viewmodel.ReportsViewModel

@Composable
fun ReportsScreen(
    viewModel: ReportsViewModel = hiltViewModel()
) {

    val data by viewModel.expensesByCategory.collectAsState()

    Scaffold { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text = "Relatórios",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (data.isEmpty()) {

                EmptyState()

            } else {

                ExpensesByCategoryCard(data)
            }
        }
    }
}

@Composable
private fun EmptyState() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {

        Text(
            text = "Nenhuma despesa registrada",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}