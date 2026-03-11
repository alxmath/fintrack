package com.ajsoftware.fintrack.core.database.converter

import androidx.room.TypeConverter
import com.ajsoftware.fintrack.core.database.model.CategoryType

class CategoryTypeConverter {

    @TypeConverter
    fun fromCategoryType(type: CategoryType): String {
        return type.name
    }

    @TypeConverter
    fun toCategorytype(value: String): CategoryType {
        return CategoryType.valueOf(value)
    }
}