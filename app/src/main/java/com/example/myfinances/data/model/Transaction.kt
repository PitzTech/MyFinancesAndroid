package com.example.myfinances.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.Date

@Entity(tableName = "transactions",
    foreignKeys = [
        ForeignKey(entity = Category::class, parentColumns = ["id"], childColumns = ["categoryId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["userId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Bank::class, parentColumns = ["id"], childColumns = ["bankId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = CreditCard::class, parentColumns = ["id"], childColumns = ["creditCardId"], onDelete = ForeignKey.CASCADE)
    ])
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val value: BigDecimal,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val categoryId: Int,
    val userId: Int,
    val dueDate: Date?,
    val receivedDate: Date?,
    val destination: String?,
    val bankId: Int?,
    val creditCardId: Int?,
    val isPaid: Boolean?,
    val origin: String?
)
