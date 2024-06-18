package com.example.myfinances.ui.viewmodel

import androidx.lifecycle.*
import com.example.myfinances.data.repository.TransactionRepository
import kotlinx.coroutines.launch

class MenuViewModel(private val transactionRepository: TransactionRepository) : ViewModel() {

    private val _balance = MutableLiveData<Double>()
    val balance: LiveData<Double> = _balance

    private val _expensesSummary = MutableLiveData<String>()
    val expensesSummary: LiveData<String> = _expensesSummary

    private val _incomeSummary = MutableLiveData<String>()
    val incomeSummary: LiveData<String> = _incomeSummary

    private val _transactions = MutableLiveData<List<com.example.myfinances.data.model.Transaction>>()
    val transactions: LiveData<List<com.example.myfinances.data.model.Transaction>> = _transactions

    fun loadBalance() {
        viewModelScope.launch {
            _balance.value = transactionRepository.getBalance()
        }
    }

    fun loadExpensesSummary() {
        viewModelScope.launch {
            val expensesSummary = transactionRepository.getExpensesSummary()
            _expensesSummary.value = expensesSummary.toString()
        }
    }

    fun loadIncomeSummary() {
        viewModelScope.launch {
            val incomeSummary = transactionRepository.getIncomeSummary()
            _incomeSummary.value = incomeSummary.toString()
        }
    }

    fun loadTransactions() {
        viewModelScope.launch {
            val transactions = transactionRepository.getAllTransactions()
            // Agora podemos atribuir diretamente a lista de transações ao _transactions
            _transactions.postValue(transactions.value)
        }
    }
}
