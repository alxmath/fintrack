package com.ajsoftware.fintrack.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ajsoftware.fintrack.core.database.entity.TransactionEntity
import com.ajsoftware.fintrack.core.model.TransactionType
import com.ajsoftware.fintrack.features.reports.domain.model.CategoryExpense
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: TransactionEntity)

    @Update
    suspend fun update(transaction: TransactionEntity)

    @Delete
    suspend fun delete(transaction: TransactionEntity)

    @Query("SELECT * FROM transactions ORDER BY date DESC")
    fun getAll(): Flow<List<TransactionEntity>>

    @Query("SELECT * FROM transactions WHERE id = :id")
    suspend fun getById(id: Long): TransactionEntity?

    @Query(
        """
            SELECT * FROM transactions
            WHERE date BETWEEN :start AND :end
            ORDER BY date DESC
        """
    )
    suspend fun getByPeriod(start: Long, end: Long): List<TransactionEntity>

    @Query(
        """
            SELECT SUM(amount) FROM transactions WHERE type = :type
        """
    )
    fun getTotalByType(type: TransactionType): Flow<Double?>

    @Query(
        """
            SELECT SUM(amount) FROM transactions
        """
    )
    fun getTotal(): Flow<Double?>

    @Query("""
        SELECT c.name as categoryName, SUM(t.amount) as total
        FROM transactions t
        JOIN categories c ON c.id = t.categoryId
        WHERE t.type = 'EXPENSE'
        GROUP BY t.categoryId
        ORDER BY total DESC
    """)
    fun getExpensesByCategory(): Flow<List<CategoryExpense>>
}
