package com.example.myfinances.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myfinances.data.model.Transaction

@Dao
interface TransactionDao {

    @Query("SELECT SUM(amount) FROM transactions WHERE type = 'income'")
    suspend fun getTotalIncome(): Double

    @Query("SELECT SUM(amount) FROM transactions WHERE type = 'expense'")
    suspend fun getTotalExpenses(): Double

    @Query("SELECT * FROM transactions")
    fun getAllTransactions(): LiveData<List<Transaction>>

    @Query("SELECT * FROM transactions WHERE id = :id")
    suspend fun getTransactionById(id: Long): Transaction?

    @Insert
    suspend fun insert(transaction: Transaction)

    @Update
    suspend fun update(transaction: Transaction)

    @Query("DELETE FROM transactions WHERE id = :id")
    suspend fun delete(id: Int)
}
