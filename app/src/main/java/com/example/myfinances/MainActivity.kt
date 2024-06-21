package com.example.myfinances

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfinances.ui.components.AppBase
import com.example.myfinances.ui.navigation.NavRoutes
import com.example.myfinances.ui.view.LoginScreen
import com.example.myfinances.ui.view.SignInScreen
import com.example.myfinances.ui.view.StartScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppBase {
                App()
            }
        }
    }
}

@Composable
fun App() {
    AppBase {
        val navController = rememberNavController()

        val isAuthenticated = false

        val startDestination = if (isAuthenticated) NavRoutes.START else NavRoutes.START

        NavHost(navController = navController, startDestination = startDestination) {
            composable(NavRoutes.LOGIN) { LoginScreen(navController) }
            composable(NavRoutes.SIGNIN) { SignInScreen(navController) }
            composable(NavRoutes.START) { StartScreen(navController) }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    AppBase {
        App()
    }
}