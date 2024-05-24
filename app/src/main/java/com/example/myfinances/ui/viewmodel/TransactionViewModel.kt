package com.example.myfinances.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myfinances.data.database.DatabaseProvider
import com.example.myfinances.data.model.Transaction
import com.example.myfinances.data.repository.TransactionRepository

class TransactionViewModel(application: Application) : AndroidViewModel(application) {
    private val transactionRepository: TransactionRepository

    init {
        val transactionDao = DatabaseProvider.getDatabase(application).transactionDao()
        transactionRepository = TransactionRepository(transactionDao)
    }

    fun getTransactionById(id: Int): LiveData<Transaction> = transactionRepository.getTransactionById(id)
    fun getAllTransactions(): LiveData<List<Transaction>> = transactionRepository.getAllTransactions()
    fun insert(transaction: Transaction) = transactionRepository.insert(transaction)
    fun update(transaction: Transaction) = transactionRepository.update(transaction)
    fun delete(transaction: Transaction) = transactionRepository.delete(transaction)
}
