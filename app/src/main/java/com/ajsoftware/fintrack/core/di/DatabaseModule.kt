package com.ajsoftware.fintrack.core.di

import android.content.Context
import androidx.room.Room
import com.ajsoftware.fintrack.core.database.FinTrackDatabase
import com.ajsoftware.fintrack.core.database.dao.CategoryDao
import com.ajsoftware.fintrack.core.database.dao.TransactionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): FinTrackDatabase{
        return Room.databaseBuilder(
            context,
            FinTrackDatabase::class.java,
            "fintrack.db"
        ).build()
    }

    @Provides
    fun provideCategoryDao(database: FinTrackDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    fun provideTransactionDao(database: FinTrackDatabase): TransactionDao {
        return database.transactionDao()
    }
}