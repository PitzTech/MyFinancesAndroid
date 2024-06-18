package com.example.myfinances.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val type: String, // 'income' or 'expense'
    val amount: Double,
    val date: String, // Use a suitable format or type for date
    val description: String
)
