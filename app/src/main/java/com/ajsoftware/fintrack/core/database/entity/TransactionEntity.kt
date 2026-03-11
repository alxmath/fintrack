package com.ajsoftware.fintrack.core.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ajsoftware.fintrack.core.model.TransactionType

@Entity(
    tableName = "transactions",
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("categoryId"), Index("date")]
)
data class TransactionEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val amount: Double,

    val description: String?,

    val categoryId: Long,

    val type: TransactionType,

    val date: Long
)