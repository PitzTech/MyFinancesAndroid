package com.example.myfinances.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "categories",
    indices = [Index(value = ["userId"])],
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val userId: Int,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val type: String
)
