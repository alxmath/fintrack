package com.ajsoftware.fintrack.features.transactions.domain.usecase

import com.ajsoftware.fintrack.core.model.TransactionType
import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction
import com.ajsoftware.fintrack.features.transactions.domain.repository.TransactionRepository
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetFinancialSummaryUseCaseTest {

    private val repository: TransactionRepository = mockk()

    private lateinit var useCase: GetFinancialSummaryUseCase

    @Before
    fun setup() {
        useCase = GetFinancialSummaryUseCase(repository)
    }

    @Test
    fun `should calculate correct balance`() = runTest {

        every { repository.getTotalByType(TransactionType.INCOME) } returns flowOf(100.0)

        every { repository.getTotalByType(TransactionType.EXPENSE) } returns flowOf(40.0)

        val result = useCase().first()

        assertThat(result.totalIncome).isEqualTo(100.0)
        assertThat(result.totalExpense).isEqualTo(40.0)
        assertThat(result.balance).isEqualTo(60.0)
    }
}