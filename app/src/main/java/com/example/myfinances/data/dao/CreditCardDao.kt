package com.example.myfinances.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myfinances.data.model.CreditCard

@Dao
interface CreditCardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(creditCard: CreditCard)

    @Update
    fun update(creditCard: CreditCard)

    @Delete
    fun delete(creditCard: CreditCard)

    @Query("SELECT * FROM creditCards WHERE id = :id")
    fun getCreditCardById(id: Int): LiveData<CreditCard>

    @Query("SELECT * FROM creditCards")
    fun getAllCreditCards(): LiveData<List<CreditCard>>
}
