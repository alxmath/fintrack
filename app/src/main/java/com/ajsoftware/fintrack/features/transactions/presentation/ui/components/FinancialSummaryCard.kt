package com.ajsoftware.fintrack.features.transactions.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajsoftware.fintrack.core.utils.formatCurrency
import com.ajsoftware.fintrack.features.dashboard.model.FinancialSummaryUi

@Composable
fun FinancialSummaryCard(
    summary: FinancialSummaryUi,
    modifier: Modifier = Modifier
) {

    val positiveColor = MaterialTheme.colorScheme.primary
    val negativeColor = MaterialTheme.colorScheme.error

    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Saldo atual",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = formatCurrency(summary.balance),
                style = MaterialTheme.typography.headlineMedium,
                color = if (summary.balance >= 0) positiveColor else negativeColor
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                SummaryItem(
                    label = "Receitas",
                    value = summary.totalIncome,
                    color = positiveColor
                )

                SummaryItem(
                    label = "Despesas",
                    value = summary.totalExpense,
                    color = negativeColor
                )
            }
        }
    }
}
