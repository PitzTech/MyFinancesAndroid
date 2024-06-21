package com.example.myfinances.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BackButton(
        navController: NavHostController,
        backgroundColor: Color,
        iconColor: Color
) {
    Box(
            modifier = Modifier
                    .size(40.dp)
                    .background(backgroundColor, shape = RoundedCornerShape(8.dp))
                    .clickable { navController.popBackStack() },
            contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = iconColor
        )
    }
}