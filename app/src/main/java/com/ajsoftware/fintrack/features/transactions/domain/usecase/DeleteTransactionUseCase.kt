package com.ajsoftware.fintrack.features.transactions.domain.usecase

import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction
import com.ajsoftware.fintrack.features.transactions.domain.repository.TransactionRepository
import javax.inject.Inject

class DeleteTransactionUseCase @Inject constructor(
    private val repository: TransactionRepository) {

    suspend operator fun invoke(transaction: Transaction){
        repository.delete(transaction)
    }
}