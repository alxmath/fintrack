package com.ajsoftware.fintrack.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ajsoftware.fintrack.core.database.converter.CategoryTypeConverter
import com.ajsoftware.fintrack.core.database.converter.TransactionTypeConverter
import com.ajsoftware.fintrack.core.database.dao.CategoryDao
import com.ajsoftware.fintrack.core.database.dao.TransactionDao
import com.ajsoftware.fintrack.core.database.entity.CategoryEntity
import com.ajsoftware.fintrack.core.database.entity.TransactionEntity

@Database(
    entities = [
        CategoryEntity::class,
        TransactionEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    CategoryTypeConverter::class,
    TransactionTypeConverter::class)
abstract class FinTrackDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    abstract fun transactionDao(): TransactionDao
}