package com.ajsoftware.fintrack.features.transactions.domain.usecase

import com.ajsoftware.fintrack.features.transactions.data.local.model.TransactionWithCategory
import com.ajsoftware.fintrack.features.transactions.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTransactionsUseCase @Inject constructor(
    private val repository: TransactionRepository
) {

    operator fun invoke(): Flow<List<TransactionWithCategory>> {
        return repository.getTransactionsWithCategory()
    }
}