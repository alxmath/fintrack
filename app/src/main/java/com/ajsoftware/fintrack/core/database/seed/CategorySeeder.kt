package com.ajsoftware.fintrack.core.database.seed

import com.ajsoftware.fintrack.core.database.dao.CategoryDao
import com.ajsoftware.fintrack.core.database.entity.CategoryEntity
import com.ajsoftware.fintrack.core.database.model.CategoryType
import javax.inject.Inject

class CategorySeeder @Inject constructor(
    private val categoryDao: CategoryDao
) {

    suspend fun seed() {

        val count = categoryDao.count()

        if (count > 0) {
            return
        }

        val defaultCategories = listOf(
            CategoryEntity(
                name = "Alimentação",
                type = CategoryType.EXPENSE,
                icon = "restaurant",
                color = "#F44336"
            ),

            CategoryEntity(
                name = "Transporte",
                type = CategoryType.EXPENSE,
                icon = "directions_car",
                color = "#FF9800"
            ),

            CategoryEntity(
                name = "Moradia",
                type = CategoryType.EXPENSE,
                icon = "home",
                color = "#9C27B0"
            ),

            CategoryEntity(
                name = "Lazer",
                type = CategoryType.EXPENSE,
                icon = "sports_esports",
                color = "#3F51B5"
            ),

            CategoryEntity(
                name = "Salário",
                type = CategoryType.INCOME,
                icon = "attach_money",
                color = "#4CAF50"
            ),

            CategoryEntity(
                name = "Freelance",
                type = CategoryType.INCOME,
                icon = "work",
                color = "#009688"
            )
        )

        defaultCategories.forEach {
            categoryDao.insert(it)
        }
    }
}