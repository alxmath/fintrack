package com.ajsoftware.fintrack.features.transactions.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ajsoftware.fintrack.features.transactions.presentation.model.TransactionUi
import com.ajsoftware.fintrack.features.transactions.presentation.viewmodel.TransactionsEvent
import com.ajsoftware.fintrack.features.transactions.presentation.viewmodel.TransactionsViewModel

@Composable
fun TransactionsScreen(
    onAddTransaction: () -> Unit,
    viewModel: TransactionsViewModel = hiltViewModel()
) {

    val transactions by viewModel.transactions.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {

        viewModel.events.collect { event ->

            when (event) {

                TransactionsEvent.TransactionSaved -> {

                    snackbarHostState.showSnackbar(
                        message = "Transação salva com sucesso"
                    )

                }

            }

        }

    }

    Scaffold(

        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },

        floatingActionButton = {

            FloatingActionButton(
                onClick = onAddTransaction
            ) {
                Text("+")
            }

        }

    ) { padding ->

        if (transactions.isEmpty()) {

            EmptyTransactions()

        } else {

            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                items(
                    items = transactions,
                    key = { it.id }
                ) { transaction ->

                    TransactionItem(transaction)

                }

            }
        }
    }
}

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
                text = "R$ %.2f".format(transaction.amount),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun EmptyTransactions() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Nenhuma transação ainda",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Toque no botão + para adicionar",
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}