package com.example.myfinances.ui.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myfinances.MyFinancesApplication
import com.example.myfinances.R
import com.example.myfinances.data.database.AppDatabase
import com.example.myfinances.data.repository.UserRepository
import com.example.myfinances.ui.viewmodel.LoginViewModel
import com.example.myfinances.ui.viewmodel.LoginViewModelFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val userDao = AppDatabase.getDatabase(this).userDao()
        val userRepository = UserRepository(userDao)
        val loginViewModelFactory = LoginViewModelFactory(userRepository)

        loginViewModel = ViewModelProvider(this, loginViewModelFactory).get(LoginViewModel::class.java)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            loginViewModel.login(email, password)
        }

        loginViewModel.loginResult.observe(this, { result ->
            // Handle login result
            if (result) {
                // Login successful, navigate to the next screen
                // e.g., startActivity(Intent(this, HomeActivity::class.java))
            } else {
                // Login failed, show error message
                // e.g., Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
