package com.example.myfinances.data.repository

import androidx.lifecycle.LiveData
import com.example.myfinances.data.dao.PreferenceDao
import com.example.myfinances.data.model.Preference

class PreferenceRepository(private val preferenceDao: PreferenceDao) {
    fun getPreferenceById(id: Int): LiveData<Preference> = preferenceDao.getPreferenceById(id)
    fun getAllPreferences(): LiveData<List<Preference>> = preferenceDao.getAllPreferences()
    fun insert(preference: Preference) = preferenceDao.insert(preference)
    fun update(preference: Preference) = preferenceDao.update(preference)
    fun delete(preference: Preference) = preferenceDao.delete(preference)
}
