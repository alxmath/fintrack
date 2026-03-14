package com.ajsoftware.fintrack.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ajsoftware.fintrack.features.transactions.presentation.ui.AddTransactionScreen
import com.ajsoftware.fintrack.features.transactions.presentation.ui.DashboardScreen
import com.ajsoftware.fintrack.features.transactions.presentation.ui.TransactionsScreen

@Composable
fun FinTrackNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = Routes.DASHBOARD,
        modifier = modifier
    ) {

        composable(Routes.DASHBOARD) {

            DashboardScreen(
                onAddTransactionClick = {
                    navController.navigate(Routes.ADD_TRANSACTION)
                }
            )
        }

        composable(Routes.TRANSACTIONS) {

            TransactionsScreen(
                navController = navController,
                onAddTransaction = {
                    navController.navigate(Routes.ADD_TRANSACTION)
                }
            )
        }

        composable(Routes.ADD_TRANSACTION) {

            AddTransactionScreen(
                onTransactionSaved = {

                    navController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.set("transaction_saved", true)

                    navController.popBackStack()

                }
            )
        }
    }
}