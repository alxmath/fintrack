package com.ajsoftware.fintrack.features.transactions.data.local.model

import androidx.room.Embedded
import androidx.room.Relation
import com.ajsoftware.fintrack.core.database.entity.CategoryEntity
import com.ajsoftware.fintrack.core.database.entity.TransactionEntity

data class TransactionWithCategory(

    @Embedded
    val transaction: TransactionEntity,

    @Relation(
        parentColumn = "categoryId",
        entityColumn = "id"
    )
    val category: CategoryEntity

)