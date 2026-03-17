package com.ajsoftware.fintrack.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ajsoftware.fintrack.features.categories.presentation.ui.CategoriesScreen
import com.ajsoftware.fintrack.features.transactions.presentation.ui.AddTransactionScreen
import com.ajsoftware.fintrack.features.dashboard.presentation.ui.DashboardScreen
import com.ajsoftware.fintrack.features.reports.presentation.ui.ReportsScreen
import com.ajsoftware.fintrack.features.transactions.presentation.ui.TransactionsScreen

@Composable
fun FinTrackNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = Route.Dashboard.route,
        modifier = modifier
    ) {

        composable(Route.Dashboard.route) {

            DashboardScreen(
                onAddTransactionClick = {
                    navController.navigate(Routes.ADD_TRANSACTION)
                },
                onSeeAllTransactionsClick = {
                    navController.navigate(Routes.TRANSACTIONS)
                }
            )
        }

        composable(Route.Transactions.route) {

            TransactionsScreen(
                navController = navController,
                onAddTransaction = {
                    navController.navigate(Routes.ADD_TRANSACTION)
                }
            )
        }

        composable(Route.AddTransaction.route) {

            AddTransactionScreen(
                onTransactionSaved = {

                    navController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.set("transaction_saved", true)

                    navController.popBackStack()

                }
            )
        }

        composable(Route.Reports.route) {
            ReportsScreen()
        }

        composable(Route.Categories.route) {
            CategoriesScreen()
        }
    }
}