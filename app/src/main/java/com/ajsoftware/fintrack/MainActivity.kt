package com.ajsoftware.fintrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.ajsoftware.fintrack.core.database.seed.CategorySeeder
import com.ajsoftware.fintrack.features.transactions.presentation.ui.TransactionsScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var categorySeeder: CategorySeeder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            categorySeeder.seed()
        }

        setContent {
            TransactionsScreen()
        }
    }
}