package com.example.myfinances.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myfinances.data.dao.BankDao
import com.example.myfinances.data.dao.CategoryDao
import com.example.myfinances.data.dao.CreditCardDao
import com.example.myfinances.data.dao.PreferenceDao
import com.example.myfinances.data.dao.TransactionDao
import com.example.myfinances.data.dao.UserDao
import com.example.myfinances.data.model.Bank
import com.example.myfinances.data.model.Category
import com.example.myfinances.data.model.CreditCard
import com.example.myfinances.data.model.Preference
import com.example.myfinances.data.model.Transaction
import com.example.myfinances.data.model.User

@Database(
    entities = [
        User::class,
        Preference::class,
        Bank::class,
        CreditCard::class,
        Category::class,
        Transaction::class
    ],
    version = 1,
    exportSchema = false
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
