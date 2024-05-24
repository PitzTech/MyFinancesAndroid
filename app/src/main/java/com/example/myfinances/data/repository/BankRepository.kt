package com.example.myfinances.data.repository

import androidx.lifecycle.LiveData
import com.example.myfinances.data.dao.BankDao
import com.example.myfinances.data.model.Bank

class BankRepository(private val bankDao: BankDao) {
    fun getBankById(id: Int): LiveData<Bank> = bankDao.getBankById(id)
    fun getAllBanks(): LiveData<List<Bank>> = bankDao.getAllBanks()
    fun insert(bank: Bank) = bankDao.insert(bank)
    fun update(bank: Bank) = bankDao.update(bank)
    fun delete(bank: Bank) = bankDao.delete(bank)
}
