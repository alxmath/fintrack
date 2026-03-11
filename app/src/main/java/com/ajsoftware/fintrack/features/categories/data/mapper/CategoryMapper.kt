package com.ajsoftware.fintrack.features.categories.data.mapper

import com.ajsoftware.fintrack.core.database.entity.CategoryEntity
import com.ajsoftware.fintrack.features.categories.domain.model.Category

fun CategoryEntity.toDomain(): Category {
    return Category(
        id = id,
        name = name,
        type = type,
        icon = icon,
        color = color
    )
}

fun Category.toEntity(): CategoryEntity {
    return CategoryEntity(
        id = id,
        name = name,
        type = type,
        icon = icon
    )
}