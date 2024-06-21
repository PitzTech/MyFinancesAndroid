package com.example.myfinances

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfinances.data.database.AppDatabase
import com.example.myfinances.data.repository.UserRepository
import com.example.myfinances.ui.components.AppBase
import com.example.myfinances.ui.navigation.NavRoutes
import com.example.myfinances.ui.view.LoginScreen
import com.example.myfinances.ui.view.SignInScreen
import com.example.myfinances.ui.view.StartScreen
import com.example.myfinances.ui.viewmodel.UserViewModel
import com.example.myfinances.ui.viewmodel.UserViewModelFactory

class MainActivity : ComponentActivity() {
    private val userViewModel: UserViewModel by viewModels {
        val userDao = AppDatabase.getDatabase(applicationContext).userDao()
        val userRepository = UserRepository(userDao)
        UserViewModelFactory(userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppBase {
                App(userViewModel)
            }
        }
    }
}

@Composable
fun App(userViewModel: UserViewModel) {
    AppBase {
        val navController = rememberNavController()

        val isAuthenticated = false

        val startDestination = if (isAuthenticated) NavRoutes.START else NavRoutes.START

        NavHost(navController = navController, startDestination = startDestination) {
            composable(NavRoutes.LOGIN) { LoginScreen(navController, userViewModel) }
            composable(NavRoutes.SIGNIN) { SignInScreen(navController, userViewModel) }
            composable(NavRoutes.START) { StartScreen(navController) }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    AppBase {
        val navController = rememberNavController()
        val userDao = AppDatabase.getDatabase(LocalContext.current).userDao()
        val userRepository = UserRepository(userDao)
        val userViewModel = viewModel<UserViewModel>(factory = UserViewModelFactory(userRepository))
        App(userViewModel)
    }
}
