package com.ajsoftware.fintrack.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Label
import androidx.compose.material.icons.filled.List

object BottomNavItems {

    val items = listOf(
        BottomNavItem(
            route = Routes.DASHBOARD,
            label = "Dashboard",
            icon = Icons.Filled.Home
        ),
        BottomNavItem(
            route = Routes.TRANSACTIONS,
            label = "Transações",
            icon = Icons.Filled.List
        ),
        BottomNavItem(
            route = Routes.REPORTS,
            label = "Relatórios",
            icon = Icons.Filled.BarChart
        ),
        BottomNavItem(
            route = Routes.CATEGORIES,
            label = "Categorias",
            icon = Icons.Filled.Label
        )
    )
}