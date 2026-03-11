package com.ajsoftware.fintrack.core.di

import com.ajsoftware.fintrack.features.categories.domain.repository.CategoryRepository
import com.ajsoftware.fintrack.features.transactions.data.repository.CategoryRepositoryImpl
import com.ajsoftware.fintrack.features.transactions.data.repository.TransactionRepositoryImpl
import com.ajsoftware.fintrack.features.transactions.domain.repository.TransactionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTransactionRepository(
        repositoryImpl: TransactionRepositoryImpl
    ): TransactionRepository

    @Binds
    @Singleton
    abstract fun bindCategoryRepository(
        repositoryImpl: CategoryRepositoryImpl
    ): CategoryRepository
}