package com.ajsoftware.fintrack.features.transactions.domain.usecase

import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction
import com.ajsoftware.fintrack.features.transactions.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTransactionsUseCase @Inject constructor(
    private val repository: TransactionRepository
) {

    operator fun invoke() =
        repository.getTransactionsWithCategory()
}