package com.example.myfinances.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myfinances.data.database.AppDatabase
import com.example.myfinances.data.model.User
import com.example.myfinances.data.repository.UserRepository
import com.example.myfinances.ui.components.BackButton
import com.example.myfinances.ui.components.CustomButton
import com.example.myfinances.ui.components.CustomTextField
import com.example.myfinances.ui.theme.primaryButton
import com.example.myfinances.ui.theme.primaryText
import com.example.myfinances.ui.theme.secondaryButton
import com.example.myfinances.ui.viewmodel.UserViewModel
import com.example.myfinances.ui.viewmodel.UserViewModelFactory
import java.util.Date

class SignInActivity : ComponentActivity() {
    private val userViewModel: UserViewModel by viewModels {
        val userDao = AppDatabase.getDatabase(applicationContext).userDao()
        val userRepository = UserRepository(userDao)
        UserViewModelFactory(userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SignInScreen(navController, userViewModel)
        }
    }
}

@Composable
fun SignInScreen(navController: NavHostController, userViewModel: UserViewModel) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    fun handleCreateUser() {
        val newUser = User(
            username = username,
            email = email,
            password = password,
            createdAt = Date(),
            updatedAt = Date()
        )
        userViewModel.createUser(newUser)
        // Navegar para a próxima tela, se necessário
        // navController.navigate("next_screen")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            BackButton(
                navController = navController,
                backgroundColor = MaterialTheme.colorScheme.secondaryButton,
                iconColor = MaterialTheme.colorScheme.background
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "SignIn",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 32.sp,
                    color = MaterialTheme.colorScheme.primaryText,
                )
            )

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = "Name"
                )

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "Email address"
                )

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Password"
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomButton(
                    text = "See finances",
                    backgroundColor = MaterialTheme.colorScheme.primaryButton,
                    textColor = MaterialTheme.colorScheme.primaryText,
                    onClick = { handleCreateUser() }
                )
            }
        }
    }
}

