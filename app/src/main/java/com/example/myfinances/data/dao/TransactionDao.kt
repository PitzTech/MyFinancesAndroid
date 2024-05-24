package com.example.myfinances.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myfinances.data.model.Transaction

@Dao
interface TransactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(transaction: Transaction)

    @Update
    fun update(transaction: Transaction)

    @Delete
    fun delete(transaction: Transaction)

    @Query("SELECT * FROM transactions WHERE id = :id")
    fun getTransactionById(id: Int): LiveData<Transaction>

    @Query("SELECT * FROM transactions")
    fun getAllTransactions(): LiveData<List<Transaction>>
}
