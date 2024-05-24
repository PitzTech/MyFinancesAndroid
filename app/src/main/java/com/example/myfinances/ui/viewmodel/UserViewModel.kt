package com.example.myfinances.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myfinances.data.database.DatabaseProvider
import com.example.myfinances.data.model.User
import com.example.myfinances.data.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepository: UserRepository

    init {
        val userDao = DatabaseProvider.getDatabase(application).userDao()
        userRepository = UserRepository(userDao)
    }

    fun getUserById(id: Int): LiveData<User> = userRepository.getUserById(id)
    fun getAllUsers(): LiveData<List<User>> = userRepository.getAllUsers()
    fun insert(user: User) = userRepository.insert(user)
    fun update(user: User) = userRepository.update(user)
    fun delete(user: User) = userRepository.delete(user)
}
