package com.example.myfinances.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "preferences",
    foreignKeys = [ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["user_id"], onDelete = ForeignKey.CASCADE)])
data class Preference(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val userId: Int,
    val isDarkModeOn: Boolean,
    val currency: String,
    val language: String
)