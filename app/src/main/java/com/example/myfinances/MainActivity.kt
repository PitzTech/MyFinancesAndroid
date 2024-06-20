package com.example.myfinances

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.myfinances.ui.theme.MyFinancesTheme
import com.example.myfinances.ui.view.LoginActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppBase()
        }
    }
}

@Composable
fun AppBase() {
    MyFinancesTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val context = LocalContext.current

    val isAuthenticated = false

    LaunchedEffect(isAuthenticated) {
        if (isAuthenticated) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        } else {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Loading")
    }
}

@Preview
@Composable
fun AppPreview() {
    MyFinancesTheme {
        AppBase()
    }
}