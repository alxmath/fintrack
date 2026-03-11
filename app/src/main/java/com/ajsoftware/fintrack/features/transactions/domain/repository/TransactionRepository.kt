package com.ajsoftware.fintrack.features.transactions.domain.repository

import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction

interface TransactionRepository {

    suspend fun insert(transaction: Transaction)
    suspend fun update(transaction: Transaction)
    suspend fun delete(transaction: Transaction)
    suspend fun getAll(): List<Transaction>
    suspend fun getById(id: Long): Transaction?
}