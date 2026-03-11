package com.ajsoftware.fintrack.features.categories.data.repository

import com.ajsoftware.fintrack.core.database.dao.CategoryDao
import com.ajsoftware.fintrack.features.categories.data.mapper.toEntity
import com.ajsoftware.fintrack.features.categories.data.mapper.toDomain
import com.ajsoftware.fintrack.features.categories.domain.model.Category
import com.ajsoftware.fintrack.features.categories.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryrRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao
) : CategoryRepository {

    override suspend fun insert(category: Category) {
        categoryDao.insert(category.toEntity())
    }

    override suspend fun update(category: Category) {
        categoryDao.update(category.toEntity())
    }

    override suspend fun delete(category: Category) {
        categoryDao.delete(category.toEntity())
    }

    override fun getAll(): Flow<List<Category>> {
        return categoryDao
            .getAll()
            .map { list -> list.map { it.toDomain() } }
    }
}