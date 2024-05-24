package com.example.myfinances.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myfinances.data.database.DatabaseProvider
import com.example.myfinances.data.model.Bank
import com.example.myfinances.data.repository.BankRepository

class BankViewModel(application: Application) : AndroidViewModel(application) {
    private val bankRepository: BankRepository

    init {
        val bankDao = DatabaseProvider.getDatabase(application).bankDao()
        bankRepository = BankRepository(bankDao)
    }

    fun getBankById(id: Int): LiveData<Bank> = bankRepository.getBankById(id)
    fun getAllBanks(): LiveData<List<Bank>> = bankRepository.getAllBanks()
    fun insert(bank: Bank) = bankRepository.insert(bank)
    fun update(bank: Bank) = bankRepository.update(bank)
    fun delete(bank: Bank) = bankRepository.delete(bank)
}
