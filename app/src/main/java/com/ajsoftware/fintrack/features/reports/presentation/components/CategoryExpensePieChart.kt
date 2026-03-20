package com.ajsoftware.fintrack.features.reports.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import com.ajsoftware.fintrack.features.reports.presentation.model.CategoryExpenseUi
import androidx.core.graphics.toColorInt

@Composable
fun CategoryExpensePieChart(
    data: List<CategoryExpenseUi>,
    modifier: Modifier = Modifier
) {

    val total = data.sumOf { it.amount }

    val animatedProgress = remember { Animatable(0f) }

    LaunchedEffect(data) {
        animatedProgress.snapTo(0f)
        animatedProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 800,
                easing = FastOutSlowInEasing
            )
        )
    }

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

            val fullSweep = (item.amount.toFloat() / total.toFloat()) * 360f
            val animatedSweep = fullSweep * animatedProgress.value

            drawArc(
                color = Color(android.graphics.Color.parseColor(item.color ?: "#CCCCCC")),
                startAngle = startAngle,
                sweepAngle = animatedSweep,
                useCenter = true
            )

            startAngle += fullSweep // ⚠️ usa o valor REAL, não o animado
        }
    }
}