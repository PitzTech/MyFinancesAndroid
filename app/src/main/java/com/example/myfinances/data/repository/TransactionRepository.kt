package com.example.myfinances.data.repository

import androidx.lifecycle.LiveData
import com.example.myfinances.data.dao.TransactionDao
import com.example.myfinances.data.model.Transaction

class TransactionRepository(private val transactionDao: TransactionDao) {
    fun getTransactionById(id: Int): LiveData<Transaction> = transactionDao.getTransactionById(id)
    fun getAllTransactions(): LiveData<List<Transaction>> = transactionDao.getAllTransactions()
    fun insert(transaction: Transaction) = transactionDao.insert(transaction)
    fun update(transaction: Transaction) = transactionDao.update(transaction)
    fun delete(transaction: Transaction) = transactionDao.delete(transaction)
}
