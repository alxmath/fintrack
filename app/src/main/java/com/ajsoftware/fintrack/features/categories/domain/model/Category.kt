package com.ajsoftware.fintrack.features.categories.domain.model

import com.ajsoftware.fintrack.core.model.CategoryType

data class Category(
    val id: Long,

    val name: String,

    val type: CategoryType,

    val icon: String? = null,

    val color: String? = null
)
