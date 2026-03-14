package com.ajsoftware.fintrack.features.dashboard.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajsoftware.fintrack.features.transactions.presentation.model.TransactionUi
import com.ajsoftware.fintrack.features.transactions.presentation.ui.TransactionItem
import kotlin.collections.take

@Composable
fun RecentTransactionsSection(
    transactions: List<TransactionUi>,
    onSeeAllClick: () -> Unit
) {

    Column {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Últimas transações",
                style = MaterialTheme.typography.titleMedium
            )

            TextButton(onClick = onSeeAllClick) {
                Text("Ver todas")
            }

        }

        Spacer(modifier = Modifier.height(8.dp))

        if (transactions.isEmpty()) {

            Text(
                text = "Nenhuma transação ainda",
                style = MaterialTheme.typography.bodyMedium
            )

        } else {

            transactions.take(5).forEach { transaction ->

                TransactionItem(transaction)

            }

        }
    }
}