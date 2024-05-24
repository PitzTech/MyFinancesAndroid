package com.example.myfinances.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val surname: String,
    val email: String,
    val password: String,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)
