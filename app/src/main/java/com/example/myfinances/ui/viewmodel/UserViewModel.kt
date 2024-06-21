package com.example.myfinances.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.myfinances.data.model.User
import com.example.myfinances.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> get() = _user

    fun createUser(user: User) {
        viewModelScope.launch {
            userRepository.createUser(user)
        }
    }

    fun getUserById(userId: Long) {
        viewModelScope.launch {
            val retrievedUser = userRepository.getUserById(userId)
            _user.value = retrievedUser
        }
    }

    fun getAllUsers(): LiveData<List<User>> = liveData {
        val users = userRepository.getAllUsers()
        emit(users)
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            userRepository.updateUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch {
            userRepository.deleteUser(user)
        }
    }

    fun authenticateUser(email: String, password: String) {
        viewModelScope.launch {
            val authenticatedUser = userRepository.authenticateUser(email, password)
            _user.value = authenticatedUser
        }
    }
}
