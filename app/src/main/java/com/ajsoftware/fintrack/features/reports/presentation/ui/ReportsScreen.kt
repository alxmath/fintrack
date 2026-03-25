package com.ajsoftware.fintrack.features.reports.presentation.ui

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajsoftware.fintrack.features.reports.domain.model.ReportPeriod
import com.ajsoftware.fintrack.features.reports.presentation.viewmodel.ReportsViewModel

@Composable
fun ReportsScreen(
    viewModel: ReportsViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()
    val selectedPeriod by viewModel.period.collectAsState()

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

            if (uiState.categories.isEmpty()) {

                EmptyState()

            } else {

                val selectedPeriod by viewModel.period.collectAsState()

                Row(
                    horizontalArrangement = spacedBy(8.dp)
                ) {

                    ReportPeriod.entries.forEach { period ->

                        FilterChip(
                            selected = selectedPeriod == period,
                            onClick = { viewModel.selectPeriod(period) },
                            label = {
                                Text(
                                    when (period) {
                                        ReportPeriod.LAST_7_DAYS -> "7 dias"
                                        ReportPeriod.LAST_30_DAYS -> "30 dias"
                                        ReportPeriod.LAST_90_DAYS -> "90 dias"
                                    }
                                )
                            }
                        )
                    }
                }

                ExpensesByCategoryCard(
                    data = uiState.categories,
                    selectedCategory = uiState.selectedCategory,
                    onCategoryClick = { clicked ->

                        val newValue =
                            if (uiState.selectedCategory == clicked) null else clicked

                        viewModel.selectCategory(newValue)
                    }
                )
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