package com.example.myfinances.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfinances.data.model.Transaction
import com.example.myfinances.data.repository.TransactionRepository
import kotlinx.coroutines.launch

class TransactionViewModel(private val repository: TransactionRepository) : ViewModel() {
    // LiveData to hold the list of transactions
    private val _transactions = MutableLiveData<List<Transaction>>()
    val transactions: LiveData<List<Transaction>> get() = _transactions

    // Method to add a transaction
    fun addTransaction(transaction: Transaction) {
        viewModelScope.launch {
            try {
                repository.insert(transaction)
                Log.d("TransactionViewModel", "Transaction added: $transaction")
                loadTransactions(transaction.userId)  // Refresh the list after adding a transaction
            } catch (e: Exception) {
                Log.e("TransactionViewModel", "Error adding transaction", e)
            }
        }
    }

    // Method to load transactions for a specific user
    fun loadTransactions(userId: Int) {
        viewModelScope.launch {
            try {
                val transactionList = repository.getAllTransactions(userId)
                _transactions.postValue(transactionList)
                Log.d("TransactionViewModel", "Transactions loaded for user: $userId")
            } catch (e: Exception) {
                Log.e("TransactionViewModel", "Error loading transactions", e)
            }
        }
    }
}
