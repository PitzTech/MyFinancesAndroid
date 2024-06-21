package com.example.myfinances.data.repository

import com.example.myfinances.data.dao.TransactionDao
import com.example.myfinances.data.model.Transaction


class TransactionRepository(private val transactionDao: TransactionDao) {

    suspend fun insert(transaction: Transaction) {
        transactionDao.insert(transaction)
    }

    suspend fun getAllTransactions(userId: Int): List<Transaction> {
        return transactionDao.getAllTransactions(userId)
    }
}
