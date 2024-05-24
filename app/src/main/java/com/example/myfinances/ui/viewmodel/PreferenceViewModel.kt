package com.example.myfinances.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myfinances.data.database.DatabaseProvider
import com.example.myfinances.data.model.Preference
import com.example.myfinances.data.repository.PreferenceRepository

class PreferenceViewModel(application: Application) : AndroidViewModel(application) {
    private val preferenceRepository: PreferenceRepository

    init {
        val preferenceDao = DatabaseProvider.getDatabase(application).preferenceDao()
        preferenceRepository = PreferenceRepository(preferenceDao)
    }

    fun getPreferenceById(id: Int): LiveData<Preference> = preferenceRepository.getPreferenceById(id)
    fun getAllPreferences(): LiveData<List<Preference>> = preferenceRepository.getAllPreferences()
    fun insert(preference: Preference) = preferenceRepository.insert(preference)
    fun update(preference: Preference) = preferenceRepository.update(preference)
    fun delete(preference: Preference) = preferenceRepository.delete(preference)
}
