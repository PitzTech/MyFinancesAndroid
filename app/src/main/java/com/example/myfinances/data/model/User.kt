package com.example.myfinances.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val username: String,
    val email: String,
    val password: String,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)
