package com.ajsoftware.fintrack.features.transactions.data.repository

import com.ajsoftware.fintrack.core.database.dao.TransactionDao
import com.ajsoftware.fintrack.core.model.TransactionType
import com.ajsoftware.fintrack.features.transactions.data.local.model.TransactionWithCategory
import com.ajsoftware.fintrack.features.transactions.data.mapper.toDomain
import com.ajsoftware.fintrack.features.transactions.data.mapper.toEntity
import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction
import com.ajsoftware.fintrack.features.transactions.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao
) : TransactionRepository {

    override suspend fun insert(transaction: Transaction) {
        transactionDao.insert(transaction.toEntity())
    }

    override suspend fun update(transaction: Transaction) {
        transactionDao.update(transaction.toEntity())
    }

    override suspend fun delete(transaction: Transaction) {
        transactionDao.delete(transaction.toEntity())
    }

    override fun getAll(): Flow<List<Transaction>> {
        return transactionDao
            .getAll()
            .map { list -> list.map { it.toDomain() } }
    }

    override suspend fun getById(id: Long): Transaction? {
        return transactionDao.getById(id)?.toDomain()
    }

    override fun getTotalByType(type: TransactionType): Flow<Double?> {
        return transactionDao.getTotalByType(type)
    }

    override fun getTransactionsWithCategory(): Flow<List<TransactionWithCategory>> {
        return transactionDao.getTransactionsWithCategory()
    }
}