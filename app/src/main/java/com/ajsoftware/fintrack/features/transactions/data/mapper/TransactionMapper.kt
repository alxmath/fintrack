package com.ajsoftware.fintrack.features.transactions.data.mapper

import com.ajsoftware.fintrack.core.database.entity.TransactionEntity
import com.ajsoftware.fintrack.features.transactions.data.local.model.TransactionWithCategory
import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction
import com.ajsoftware.fintrack.features.transactions.presentation.model.TransactionUi

fun TransactionEntity.toDomain(): Transaction {
    return Transaction(
        id = id,
        amount = amount,
        description = description,
        categoryId = categoryId,
        type = type,
        date = date,
    )
}

fun Transaction.toEntity(): TransactionEntity {
    return TransactionEntity(
        id = id,
        amount = amount,
        description = description,
        categoryId = categoryId,
        type = type,
        date = date,
    )
}

fun TransactionWithCategory.toUi(): TransactionUi {

    return TransactionUi(
        id = transaction.id,
        description = transaction.description,
        amount = transaction.amount,
        categoryName = category.name,
        categoryIcon = category.icon,
        categoryColor = category.color,
        type = transaction.type,
        date = transaction.date
    )

}