package com.example.myfinances.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myfinances.data.model.Bank

@Dao
interface BankDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bank: Bank)

    @Update
    fun update(bank: Bank)

    @Delete
    fun delete(bank: Bank)

    @Query("SELECT * FROM banks WHERE id = :id")
    fun getBankById(id: Int): LiveData<Bank>

    @Query("SELECT * FROM banks")
    fun getAllBanks(): LiveData<List<Bank>>
}
