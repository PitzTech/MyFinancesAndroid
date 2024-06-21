package com.example.myfinances

import TransactionViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfinances.data.database.AppDatabase
import com.example.myfinances.data.repository.TransactionRepository
import com.example.myfinances.data.repository.UserRepository
import com.example.myfinances.ui.components.AppBase
import com.example.myfinances.ui.navigation.NavRoutes
import com.example.myfinances.ui.view.AddTransactionScreen
import com.example.myfinances.ui.view.HomeScreen
import com.example.myfinances.ui.view.LoginScreen
import com.example.myfinances.ui.view.SignInScreen
import com.example.myfinances.ui.view.StartScreen
import com.example.myfinances.ui.viewmodel.TransactionViewModel
import com.example.myfinances.ui.viewmodel.UserViewModel
import com.example.myfinances.ui.viewmodel.UserViewModelFactory

class MainActivity : ComponentActivity() {
    private val userViewModel: UserViewModel by viewModels {
        val userDao = AppDatabase.getDatabase(applicationContext).userDao()
        val userRepository = UserRepository(userDao)
        UserViewModelFactory(userRepository)
    }

    private val transactionViewModel: TransactionViewModel by viewModels {
        val transactionDao = AppDatabase.getDatabase(applicationContext).transactionDao()
        val transactionRepository = TransactionRepository(transactionDao)
        TransactionViewModelFactory(transactionRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppBase {
                App(userViewModel, transactionViewModel)
            }
        }
    }
}

@Composable
fun App(userViewModel: UserViewModel, transactionViewModel: TransactionViewModel) {
    AppBase {
        val navController = rememberNavController()
        val isAuthenticated by userViewModel.isAuthenticated.observeAsState(false)

        val startDestination = if (isAuthenticated) NavRoutes.HOME else NavRoutes.START

        NavHost(navController = navController, startDestination = startDestination) {
            composable(NavRoutes.LOGIN) { LoginScreen(navController, userViewModel) }
            composable(NavRoutes.SIGNIN) { SignInScreen(navController, userViewModel) }
            composable(NavRoutes.START) { StartScreen(navController) }
            composable(NavRoutes.HOME) {
                HomeScreen(
                    transactionViewModel,
                    userViewModel,
                    navController
                )
            }
            composable(NavRoutes.ADD_TRANSACTION) {
                AddTransactionScreen(
                    navController,
                    transactionViewModel,
                    userViewModel
                )
            }
        }
    }
}

