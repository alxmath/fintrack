package com.ajsoftware.fintrack.core

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ajsoftware.fintrack.core.database.FinTrackDatabase
import com.ajsoftware.fintrack.core.database.dao.TransactionDao
import com.ajsoftware.fintrack.core.database.entity.CategoryEntity
import com.ajsoftware.fintrack.core.database.entity.TransactionEntity
import com.ajsoftware.fintrack.core.model.CategoryType
import com.ajsoftware.fintrack.core.model.TransactionType
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FinTrackDatabaseTest {

    private lateinit var db: FinTrackDatabase
    private lateinit var dao: TransactionDao

    @Before
    fun setup() {

        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            FinTrackDatabase::class.java
        ).build()

        dao = db.transactionDao()
    }

    @Test
    fun insertTransaction_shouldPersist() = runTest {

        val category = CategoryEntity(
            id = 1,
            name = "Teste",
            type = CategoryType.EXPENSE,
            icon = "test",
            color = "#FFFFFF"
        )

        db.categoryDao().insert(category)

        val transaction = TransactionEntity(
            id = 1,
            amount = 50.0,
            description = "Teste",
            categoryId = 1,
            type = TransactionType.EXPENSE,
            date = 1700000000000
        )

        dao.insert(transaction)

        val result = dao.getAll().first()

        assertEquals(1, result.size)
    }
}