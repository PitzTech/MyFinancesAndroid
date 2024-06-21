package com.example.myfinances.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myfinances.R
import com.example.myfinances.ui.components.CustomButton
import com.example.myfinances.ui.navigation.NavRoutes
import com.example.myfinances.ui.theme.primaryButton
import com.example.myfinances.ui.theme.primaryText
import com.example.myfinances.ui.theme.secondaryButton

@Composable
fun StartScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 26.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(350.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(
                text = "Sign Up",
                backgroundColor = MaterialTheme.colorScheme.secondaryButton,
                textColor = MaterialTheme.colorScheme.background,
                onClick = { navController.navigate(NavRoutes.SIGNIN) }
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomButton(
                text = "Login",
                backgroundColor = MaterialTheme.colorScheme.primaryButton,
                textColor = MaterialTheme.colorScheme.primaryText,
                onClick = { navController.navigate(NavRoutes.LOGIN) }
            )
        }
    }
}
