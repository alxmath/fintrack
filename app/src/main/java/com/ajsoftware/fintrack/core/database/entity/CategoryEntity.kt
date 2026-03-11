package com.ajsoftware.fintrack.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name: String,

    val type: String, // INCOME ou EXPENSE

    val icon: String? = null,

    val color: String? = null
)