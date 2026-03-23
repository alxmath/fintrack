package com.ajsoftware.fintrack.features.reports.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajsoftware.fintrack.features.reports.presentation.components.CategoryExpenseLegend
import com.ajsoftware.fintrack.features.reports.presentation.components.CategoryExpensePieChart
import com.ajsoftware.fintrack.features.reports.presentation.model.CategoryExpenseUi

@Composable
fun ExpensesByCategoryCard(
    data: List<CategoryExpenseUi>
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Despesas por categoria",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            CategoryExpensePieChart(
                data = data,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            CategoryExpenseLegend(data = data,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 180.dp))
        }
    }
}