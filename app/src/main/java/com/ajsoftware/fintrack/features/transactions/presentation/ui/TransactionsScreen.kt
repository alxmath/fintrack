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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.navigation.NavHostController
import com.ajsoftware.fintrack.core.ui.components.TransactionItem
import com.ajsoftware.fintrack.core.utils.formatCurrency
import com.ajsoftware.fintrack.features.transactions.presentation.model.TransactionUi
import com.ajsoftware.fintrack.features.transactions.presentation.viewmodel.TransactionsEvent
import com.ajsoftware.fintrack.features.transactions.presentation.viewmodel.TransactionsViewModel

@Composable
fun TransactionsScreen(
    navController: NavHostController,
    onAddTransaction: () -> Unit,
    viewModel: TransactionsViewModel = hiltViewModel()
) {

    val transactions by viewModel.transactions.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }

    val savedStateHandle =
        navController.currentBackStackEntry?.savedStateHandle

    val transactionSaved =
        savedStateHandle?.get<Boolean>("transaction_saved") ?: false

    LaunchedEffect(transactionSaved) {

        if (transactionSaved) {

            snackbarHostState.showSnackbar(
                message = "Transação salva com sucesso"
            )

            savedStateHandle["transaction_saved"] = false

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
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Adicionar transação"
                )
            }

        }

    ) { padding ->

        if (transactions.isEmpty()) {

            EmptyTransactions()

        } else {

            val items = remember(transactions) { transactions }

            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                items(
                    items = items,
                    key = { it.id }
                ) { transaction ->

                    TransactionItem(transaction)

                }

            }
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