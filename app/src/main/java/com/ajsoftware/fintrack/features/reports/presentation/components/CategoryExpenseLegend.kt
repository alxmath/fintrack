package com.ajsoftware.fintrack.features.reports.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ajsoftware.fintrack.core.utils.formatCurrency
import com.ajsoftware.fintrack.features.reports.presentation.model.CategoryExpenseUi

@Composable
fun CategoryExpenseLegend(
    data: List<CategoryExpenseUi>
) {

    val total = data.sumOf { it.amount }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        data.forEach { item ->

            val percentage = if (total > 0) {
                (item.amount / total * 100).toInt()
            } else 0

            val color = try {
                Color(android.graphics.Color.parseColor(item.color ?: "#2196F3"))
            } catch (e: Exception) {
                Color(0xFF2196F3)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Cor
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(color, CircleShape)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Nome + valor
                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        text = item.categoryName,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = formatCurrency(item.amount),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Percentual
                Text(
                    text = "$percentage%",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}