package com.example.myfinances.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myfinances.data.model.Preference

@Dao
interface PreferenceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(preference: Preference)

    @Update
    fun update(preference: Preference)

    @Delete
    fun delete(preference: Preference)

    @Query("SELECT * FROM preferences WHERE id = :id")
    fun getPreferenceById(id: Int): LiveData<Preference>

    @Query("SELECT * FROM preferences")
    fun getAllPreferences(): LiveData<List<Preference>>
}
