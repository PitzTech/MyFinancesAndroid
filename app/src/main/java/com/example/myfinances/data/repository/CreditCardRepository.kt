package com.example.myfinances.data.repository

import androidx.lifecycle.LiveData
import com.example.myfinances.data.dao.CreditCardDao
import com.example.myfinances.data.model.CreditCard

class CreditCardRepository(private val creditCardDao: CreditCardDao) {
    fun getCreditCardById(id: Int): LiveData<CreditCard> = creditCardDao.getCreditCardById(id)
    fun getAllCreditCards(): LiveData<List<CreditCard>> = creditCardDao.getAllCreditCards()
    fun insert(creditCard: CreditCard) = creditCardDao.insert(creditCard)
    fun update(creditCard: CreditCard) = creditCardDao.update(creditCard)
    fun delete(creditCard: CreditCard) = creditCardDao.delete(creditCard)
}
