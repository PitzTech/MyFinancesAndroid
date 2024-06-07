package com.example.myfinances.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myfinances.data.dao.*
import com.example.myfinances.data.model.*
import androidx.room.TypeConverters

@Database(entities = [
    User::class,
    Preference::class,
    Bank::class,
    CreditCard::class,
    Category::class,
    Transaction::class
                     ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun preferenceDao(): PreferenceDao
    abstract fun bankDao(): BankDao
    abstract fun creditCardDao(): CreditCardDao
    abstract fun categoryDao(): CategoryDao
    abstract fun transactionDao(): TransactionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "myfinances_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
