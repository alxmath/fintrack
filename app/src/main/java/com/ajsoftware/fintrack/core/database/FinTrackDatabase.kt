package com.ajsoftware.fintrack.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ajsoftware.fintrack.core.database.dao.CategoryDao
import com.ajsoftware.fintrack.core.database.dao.TransactionDao

@Database(
    entities = [

    ],
    version = 1,
    exportSchema = true
)
abstract class FinTrackDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    abstract fun transactionDao(): TransactionDao
}