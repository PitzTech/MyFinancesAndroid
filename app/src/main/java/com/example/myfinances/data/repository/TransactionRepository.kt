package com.example.myfinances.data.repository

import androidx.lifecycle.LiveData
import com.example.myfinances.data.dao.TransactionDao
import com.example.myfinances.data.model.Transaction

class TransactionRepository(private val transactionDao: TransactionDao) {

    fun getAllTransactions(userId: Int): LiveData<List<Transaction>> {
        return transactionDao.getAllTransactions(userId)
    }

    suspend fun insertTransaction(transaction: Transaction) {
        transactionDao.insert(transaction)
    }
}
