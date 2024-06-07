package com.example.myfinances.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "creditCards",
    indices = [Index(value = ["bankId"])],
    foreignKeys = [ForeignKey(
        entity = Bank::class,
        parentColumns = ["id"],
        childColumns = ["bankId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class CreditCard(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val bankId: Int,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val holderName: String,
    val last4Digits: String
)
