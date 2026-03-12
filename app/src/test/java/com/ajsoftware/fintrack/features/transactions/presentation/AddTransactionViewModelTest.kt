package com.ajsoftware.fintrack.features.transactions.presentation

import com.ajsoftware.fintrack.core.model.TransactionType
import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction
import com.ajsoftware.fintrack.features.transactions.domain.repository.TransactionRepository
import com.ajsoftware.fintrack.features.transactions.domain.usecase.AddTransactionUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class AddTransactionUseCaseTest {

    private val repository: TransactionRepository = mockk()

    private lateinit var useCase: AddTransactionUseCase

    @Before
    fun setup() {
        useCase = AddTransactionUseCase(repository)
    }

    @Test
    fun `should call repository insert`() = runTest {

        val transaction = Transaction(
            id = 1,
            amount = 100.0,
            description = "Salário",
            categoryId = 1,
            type = TransactionType.INCOME,
            date = 1700000000000
        )

        coEvery { repository.insert(transaction) } returns Unit

        useCase(transaction)

        coVerify(exactly = 1) {
            repository.insert(transaction)
        }
    }
}