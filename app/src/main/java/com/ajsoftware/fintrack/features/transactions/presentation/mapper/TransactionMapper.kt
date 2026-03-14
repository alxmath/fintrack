package com.ajsoftware.fintrack.features.transactions.presentation.mapper

import com.ajsoftware.fintrack.features.transactions.domain.model.Transaction
import com.ajsoftware.fintrack.features.transactions.presentation.model.TransactionUi

fun Transaction.toUi(categoryName: String): TransactionUi {

    return TransactionUi(
        id = id,
        description = description,
        amount = amount,
        categoryName = categoryName,
        type = type,
        date = date
    )

}