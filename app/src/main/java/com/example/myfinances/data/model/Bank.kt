package com.example.myfinances.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.Date

@Entity(tableName = "banks",
    indices = [Index(value = ["userId"])],
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Bank(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val currentValue: BigDecimal,
    val dueDate: Date,
    val endDate: Date,
    val color: String,
    val userId: Int
)
