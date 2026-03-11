package com.ajsoftware.fintrack.core.database.converter

import androidx.room.TypeConverter
import com.ajsoftware.fintrack.core.model.TransactionType

class TransactionTypeConverter {

    @TypeConverter
    fun fromTransactionType(type: TransactionType): String {
        return type.name
    }

    @TypeConverter
    fun toTransactionType(value: String): TransactionType {
        return TransactionType.valueOf(value)
    }
}