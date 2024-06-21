package com.example.myfinances.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myfinances.data.model.User

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user WHERE id = :userId")
    suspend fun getUserById(userId: Long): User?

    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<User>

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM user WHERE email = :email AND password = :password LIMIT 1")
    suspend fun authenticateUser(email: String, password: String): User?
}
