package com.example.myfinances.ui.view

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
import com.example.myfinances.ui.components.BackButton
import com.example.myfinances.ui.components.CustomButton
import com.example.myfinances.ui.components.CustomTextField
import com.example.myfinances.ui.navigation.NavRoutes
import com.example.myfinances.ui.theme.primaryButton
import com.example.myfinances.ui.theme.primaryText
import com.example.myfinances.ui.theme.secondaryButton
import com.example.myfinances.ui.viewmodel.UserViewModel

@Composable
fun LoginScreen(navController: NavHostController, userViewModel: UserViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf(false) }

    fun handleLogin() {
        userViewModel.authenticateUser(email, password)
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
                text = "Login",
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
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "Email address"
                )

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Password",
                    isPassword = true
                )
            }

            if (loginError) {
                Text(
                    text = "Invalid email or password",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
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
                    onClick = { handleLogin() }
                )
            }
        }
    }

    userViewModel.user.observeForever { user ->
        if (user != null) {
            navController.navigate(NavRoutes.HOME)
        } else {
            loginError = true
        }
    }
}

