package com.ajsoftware.fintrack.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ajsoftware.fintrack.core.utils.formatCurrency
import com.ajsoftware.fintrack.features.transactions.presentation.model.TransactionUi
import androidx.core.graphics.toColorInt

@Composable
fun TransactionItem(transaction: TransactionUi) {

    val categoryColor = try {
        Color((transaction.categoryColor ?: "#2196F3").toColorInt())
    } catch (e: Exception) {
        Color(0xFF2196F3)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(categoryColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Default.Category,
                    contentDescription = null,
                    tint = Color.White
                )

            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = transaction.description ?: "Sem descrição",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = transaction.categoryName,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

            }

            Text(
                text = formatCurrency(transaction.amount),
                style = MaterialTheme.typography.titleMedium
            )

        }
    }
}