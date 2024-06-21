package com.example.myfinances.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val value: Double,
    val date: Date,
    val category: String,
    val type: String,  // 'income' or 'outcome'
    val userId: Int,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)
