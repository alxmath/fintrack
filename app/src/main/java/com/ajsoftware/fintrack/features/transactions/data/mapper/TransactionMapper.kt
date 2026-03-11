package com.ajsoftware.fintrack.features.transactions.data.mapper

import com.ajsoftware.fintrack.core.database.entity.TransactionEntity
import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction

fun TransactionEntity.toDomain(): Transaction {
    return Transaction(
        id =id,
        amount = amount,
        description = description,
        categoryId = categoryId,
        type = type,
        date = date,
    )
}

fun Transaction.toEntity(): TransactionEntity{
    return TransactionEntity(
        id =id,
        amount = amount,
        description = description,
        categoryId = categoryId,
        type = type,
        date = date,
    )
}