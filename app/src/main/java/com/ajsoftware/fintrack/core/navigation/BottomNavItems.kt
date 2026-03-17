package com.ajsoftware.fintrack.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Label
import androidx.compose.material.icons.filled.List

object BottomNavItems {

    val items = listOf(
        BottomNavItem(
            route = Route.Dashboard.route,
            label = "Dashboard",
            icon = Icons.Filled.Home
        ),
        BottomNavItem(
            route = Route.Transactions.route,
            label = "Transações",
            icon = Icons.Filled.List
        ),
        BottomNavItem(
            route = Route.Reports.route,
            label = "Relatórios",
            icon = Icons.Filled.BarChart
        ),
        BottomNavItem(
            route = Route.Categories.route,
            label = "Categorias",
            icon = Icons.Filled.Label
        )
    )
}