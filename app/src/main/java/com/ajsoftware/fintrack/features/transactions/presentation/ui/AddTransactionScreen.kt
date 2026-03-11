package com.ajsoftware.fintrack.features.transactions.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajsoftware.fintrack.core.model.TransactionType
import com.ajsoftware.fintrack.features.transactions.presentation.viewmodel.AddTransactionViewModel

@Composable
fun AddTransactionScreen(
    viewModel: AddTransactionViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Nova Transação",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = state.amount,
            onValueChange = { viewModel.updateAmount(it) },
            label = { Text("Valor") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = state.description,
            onValueChange = { viewModel.updateDescription(it) },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Tipo")

        Row {

            FilterChip(
                selected = state.selectedType == TransactionType.EXPENSE,
                onClick = { viewModel.updateType(TransactionType.EXPENSE) },
                label = { Text("Despesa") }
            )

            Spacer(modifier = Modifier.width(8.dp))

            FilterChip(
                selected = state.selectedType == TransactionType.INCOME,
                onClick = { viewModel.updateType(TransactionType.INCOME) },
                label = { Text("Receita") }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { viewModel.save() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salvar")
        }
    }
}