package com.ajsoftware.fintrack.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajsoftware.fintrack.core.utils.formatCurrency
import com.ajsoftware.fintrack.features.transactions.presentation.model.TransactionUi

@Composable
fun TransactionItem(transaction: TransactionUi) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {

                Text(
                    text = transaction.description ?: "Sem descrição",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = transaction.categoryName,
                    style = MaterialTheme.typography.bodySmall
                )

            }

            Text(
                text = formatCurrency(transaction.amount),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}