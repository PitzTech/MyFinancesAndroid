package com.example.myfinances.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfinances.ui.theme.MyFinancesTheme

@Composable
fun AppBase(content: @Composable () -> Unit) {
    MyFinancesTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(vertical = 0.dp)
                    .padding(horizontal = 20.dp),
                color = MaterialTheme.colorScheme.background
            ) {
                content()
            }
        }
    }
}

@Preview
@Composable
fun AppBasePreview() {
    AppBase {
        Text("Hello, World!")
    }
}