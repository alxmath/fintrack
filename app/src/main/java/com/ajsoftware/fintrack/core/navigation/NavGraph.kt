package com.ajsoftware.fintrack.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ajsoftware.fintrack.features.transactions.presentation.ui.AddTransactionScreen
import com.ajsoftware.fintrack.features.transactions.presentation.ui.TransactionsScreen

@Composable
fun FinTrackNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.TRANSACTIONS
    ) {

        composable(Routes.TRANSACTIONS) {

            TransactionsScreen(
                onAddTransaction = {
                    navController.navigate(Routes.ADD_TRANSACTION)
                }
            )
        }

        composable(Routes.ADD_TRANSACTION) {

            AddTransactionScreen(

                onTransactionSaved = {
                    navController.popBackStack()
                }

            )

        }
    }
}