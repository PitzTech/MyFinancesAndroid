package com.example.myfinances

import android.app.Application
import com.example.myfinances.data.database.DatabaseProvider
import com.example.myfinances.data.repository.UserRepository

class MyFinancesApplication : Application() {
    val database by lazy { DatabaseProvider.getDatabase(this) }
    val userRepository by lazy { UserRepository(database.userDao()) }
}
