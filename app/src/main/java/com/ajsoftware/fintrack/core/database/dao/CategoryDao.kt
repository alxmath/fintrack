package com.ajsoftware.fintrack.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ajsoftware.fintrack.core.database.entity.CategoryEntity
import com.ajsoftware.fintrack.core.model.CategoryType
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: CategoryEntity)

    @Update
    suspend fun update(category: CategoryEntity)

    @Delete
    suspend fun delete(category: CategoryEntity)

    @Query("SELECT * FROM categories ORDER BY name")
    fun getAll(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM categories WHERE type = :type")
    suspend fun getByType(type: CategoryType): List<CategoryEntity>

    @Query("SELECT COUNT(*) FROM categories")
    suspend fun count(): Int
}
