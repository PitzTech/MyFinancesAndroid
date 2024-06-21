package com.example.myfinances.data.repository

import com.example.myfinances.data.dao.UserDao
import com.example.myfinances.data.model.User
import java.util.Date

class UserRepository(private val userDao: UserDao) {

    suspend fun createUser(user: User) {
        userDao.insert(user)
    }

    suspend fun getUserById(userId: Long): User? {
        return userDao.getUserById(userId)
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    suspend fun updateUser(user: User) {
        userDao.update(user.copy(updatedAt = Date()))
    }

    suspend fun deleteUser(user: User) {
        userDao.delete(user)
    }

    suspend fun authenticateUser(email: String, password: String): User? {
        return userDao.authenticateUser(email, password)
    }
}
