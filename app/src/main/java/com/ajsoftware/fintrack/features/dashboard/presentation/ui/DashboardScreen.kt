package com.ajsoftware.fintrack.features.dashboard.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajsoftware.fintrack.features.transactions.presentation.ui.components.FinancialSummaryCard
import com.ajsoftware.fintrack.features.dashboard.presentation.viewmodel.DashboardViewModel
import com.ajsoftware.fintrack.features.transactions.presentation.ui.TransactionItem

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel(),
    onAddTransactionClick: () -> Unit,
    onSeeAllTransactionsClick: () -> Unit
) {

    val summary by viewModel.summary.collectAsState()

    val transactions by viewModel.transactions.collectAsState(emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddTransactionClick
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Adicionar transação"
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            FinancialSummaryCard(
                summary = summary
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Últimas transações",
                    style = MaterialTheme.typography.titleMedium
                )

                TextButton(
                    onClick = onSeeAllTransactionsClick
                ) {
                    Text("Ver todas")
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            transactions
                .take(5)
                .forEach { transaction ->

                    TransactionItem(transaction)

                }
        }
    }
}