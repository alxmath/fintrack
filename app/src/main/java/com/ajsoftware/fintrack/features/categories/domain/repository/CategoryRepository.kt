package com.ajsoftware.fintrack.features.categories.domain.repository

import com.ajsoftware.fintrack.features.categories.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    suspend fun insert(category: Category)
    suspend fun update(category: Category)
    suspend fun delete(category: Category)
    fun getAll(): Flow<List<Category>>
}