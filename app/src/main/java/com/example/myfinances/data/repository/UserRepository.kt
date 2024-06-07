package com.example.myfinances.data.repository

import androidx.lifecycle.LiveData
import com.example.myfinances.data.dao.UserDao
import com.example.myfinances.data.model.User

class UserRepository(private val userDao: UserDao) {
    fun getUserById(id: Int): LiveData<User> = userDao.getUserById(id)
    fun getAllUsers(): LiveData<List<User>> = userDao.getAllUsers()
    fun insert(user: User) = userDao.insert(user)
    fun update(user: User) = userDao.update(user)
    fun delete(user: User) = userDao.delete(user)

    suspend fun getUserByEmail(email: String): User? = userDao.getUserByEmail(email)
}
