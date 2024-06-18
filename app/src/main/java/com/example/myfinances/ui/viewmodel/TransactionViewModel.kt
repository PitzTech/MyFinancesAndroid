package com.example.myfinances.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myfinances.data.database.DatabaseProvider
import com.example.myfinances.data.model.Transaction
import com.example.myfinances.data.repository.TransactionRepository
import kotlinx.coroutines.launch

class TransactionViewModel(application: Application) : AndroidViewModel(application) {
    private val transactionRepository: TransactionRepository

    init {
        val transactionDao = DatabaseProvider.getDatabase(application).transactionDao()
        transactionRepository = TransactionRepository(transactionDao)
    }

    suspend fun getTransactionById(id: Long): Transaction? {
        return transactionRepository.getTransactionById(id)
    }

    suspend fun getAllTransactions(): LiveData<List<Transaction>> {
        return transactionRepository.getAllTransactions()
    }

    fun insert(transaction: Transaction) {
        viewModelScope.launch {
            transactionRepository.insert(transaction)
        }
    }

    fun update(transaction: Transaction) {
        viewModelScope.launch {
            transactionRepository.update(transaction)
        }
    }

    fun delete(transaction: Transaction) {
        viewModelScope.launch {
            transactionRepository.delete(transaction)
        }
    }
}
