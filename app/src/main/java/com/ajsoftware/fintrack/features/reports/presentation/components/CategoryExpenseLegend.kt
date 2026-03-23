package com.ajsoftware.fintrack.features.reports.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ajsoftware.fintrack.core.utils.formatCurrency
import com.ajsoftware.fintrack.features.reports.presentation.model.CategoryExpenseUi
import androidx.core.graphics.toColorInt

@Composable
fun CategoryExpenseLegend(
    data: List<CategoryExpenseUi>,
    modifier: Modifier = Modifier
) {

    val total = data.sumOf { it.amount }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        data.forEach { item ->

            val percentage = if (total > 0) {
                (item.amount / total * 100).toInt()
            } else 0

            val color = try {
                Color((item.color ?: "#2196F3").toColorInt())
            } catch (e: Exception) {
                Color(0xFF2196F3)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                // Cor
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(color, CircleShape)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = item.categoryName,
                            style = MaterialTheme.typography.bodyMedium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Text(
                            text = formatCurrency(item.amount),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))

                // Percentual
                Text(
                    text = "$percentage%",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.wrapContentWidth()
                )
            }
        }
    }
}