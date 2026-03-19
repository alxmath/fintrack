package com.ajsoftware.fintrack.features.reports.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ajsoftware.fintrack.features.reports.presentation.model.CategoryExpenseUi
import androidx.core.graphics.toColorInt

@Composable
fun CategoryExpensePieChart(
    data: List<CategoryExpenseUi>,
    modifier: Modifier = Modifier
) {

    val total = data.sumOf { it.amount }

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
    ) {

        var startAngle = -90f

        data.forEach { item ->

            val sweepAngle = (item.amount / total * 360f).toFloat()

            val color = try {
                Color((item.color ?: "#2196F3").toColorInt())
            } catch (e: Exception) {
                Color(0xFF2196F3)
            }

            drawArc(
                color = color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = true
            )

            startAngle += sweepAngle
        }
    }
}