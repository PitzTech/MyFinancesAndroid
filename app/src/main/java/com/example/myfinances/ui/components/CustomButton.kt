package com.example.myfinances.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
        text: String,
        backgroundColor: Color,
        textColor: Color,
        onClick: () -> Unit = {}
) {
    Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
            modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
            shape = RoundedCornerShape(15.dp)
    ) {
        Text(
                text = text,
                fontSize = 18.sp,
                color = textColor,
                style = MaterialTheme.typography.labelMedium
        )
    }
}

