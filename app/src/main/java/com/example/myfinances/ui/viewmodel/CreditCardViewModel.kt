package com.example.myfinances.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myfinances.data.database.DatabaseProvider
import com.example.myfinances.data.model.CreditCard
import com.example.myfinances.data.repository.CreditCardRepository

class CreditCardViewModel(application: Application) : AndroidViewModel(application) {
    private val creditCardRepository: CreditCardRepository

    init {
        val creditCardDao = DatabaseProvider.getDatabase(application).creditCardDao()
        creditCardRepository = CreditCardRepository(creditCardDao)
    }

    fun getCreditCardById(id: Int): LiveData<CreditCard> = creditCardRepository.getCreditCardById(id)
    fun getAllCreditCards(): LiveData<List<CreditCard>> = creditCardRepository.getAllCreditCards()
    fun insert(creditCard: CreditCard) = creditCardRepository.insert(creditCard)
    fun update(creditCard: CreditCard) = creditCardRepository.update(creditCard)
    fun delete(creditCard: CreditCard) = creditCardRepository.delete(creditCard)
}
