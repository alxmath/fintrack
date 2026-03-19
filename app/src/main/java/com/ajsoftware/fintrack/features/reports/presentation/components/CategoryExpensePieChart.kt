package com.ajsoftware.fintrack.features.reports.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import com.ajsoftware.fintrack.features.reports.presentation.model.CategoryExpenseUi

@Composable
fun CategoryExpensePieChart(
    data: List<CategoryExpenseUi>,
    modifier: Modifier = Modifier
) {

    val total = data.sumOf { it.amount }

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f) // garante área quadrada
    ) {

        if (total == 0.0) return@Canvas

        val diameter = size.minDimension

        val topLeft = Offset(
            (size.width - diameter) / 2f,
            (size.height - diameter) / 2f
        )

        val arcSize = Size(diameter, diameter)

        var startAngle = -90f

        data.forEach { item ->

            val sweepAngle = (item.amount / total * 360f).toFloat()

            val color = try {
                Color(android.graphics.Color.parseColor(item.color ?: "#2196F3"))
            } catch (e: Exception) {
                Color(0xFF2196F3)
            }

            drawArc(
                color = color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = true,
                topLeft = topLeft,
                size = arcSize
            )

            startAngle += sweepAngle
        }
    }
}