package com.example.myfinances.data.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.myfinances.data.dao.TransactionDao
import com.example.myfinances.data.model.Transaction

class TransactionRepository(private val transactionDao: TransactionDao) {

    // Obter todas as transações
    fun getAllTransactions(): LiveData<List<Transaction>> {
        return transactionDao.getAllTransactions()
    }

    // Obter saldo
    suspend fun getBalance(): Double {
        val totalIncome = transactionDao.getTotalIncome()
        val totalExpenses = transactionDao.getTotalExpenses()
        return totalIncome - totalExpenses
    }

    // Obter resumo das receitas
    suspend fun getIncomeSummary(): Double {
        return transactionDao.getTotalIncome()
    }

    suspend fun getExpensesSummary(): Double {
        return transactionDao.getTotalExpenses()
    }

    // Obter transação pelo ID
    suspend fun getTransactionById(id: Long): Transaction? {
        return withContext(Dispatchers.IO) {
            transactionDao.getTransactionById(id)
        }
    }

    // Inserir transação
    suspend fun insert(transaction: Transaction) {
        withContext(Dispatchers.IO) {
            transactionDao.insert(transaction)
        }
    }

    // Atualizar transação
    suspend fun update(transaction: Transaction) {
        withContext(Dispatchers.IO) {
            transactionDao.update(transaction)
        }
    }

    // Excluir transação
    suspend fun delete(transaction: Transaction) {
        withContext(Dispatchers.IO) {
            transactionDao.delete(transaction.id)
        }
    }
}
