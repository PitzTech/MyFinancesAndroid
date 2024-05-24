package com.example.myfinances.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myfinances.data.dao.*
import com.example.myfinances.data.model.*

@Database(entities = [User::class, Preference::class, Bank::class, CreditCard::class, Category::class, Transaction::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun preferenceDao(): PreferenceDao
    abstract fun bankDao(): BankDao
    abstract fun creditCardDao(): CreditCardDao
    abstract fun categoryDao(): CategoryDao
    abstract fun transactionDao(): TransactionDao
}
