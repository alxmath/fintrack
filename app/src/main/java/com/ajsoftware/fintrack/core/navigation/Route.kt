package com.ajsoftware.fintrack.core.navigation

sealed class Route(val route: String) {

    data object Dashboard : Route("dashboard")

    data object Transactions : Route("transactions")

    data object AddTransaction : Route("add_transaction")

    data object Reports : Route("reports")

    data object Categories : Route("categories")

}