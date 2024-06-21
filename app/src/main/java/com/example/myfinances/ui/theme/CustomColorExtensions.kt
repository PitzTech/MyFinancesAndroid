package com.example.myfinances.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val ColorScheme.primaryButton: Color
    @Composable
    get() = LocalCustomColors.current.primaryButton

val ColorScheme.secondaryButton: Color
    @Composable
    get() = LocalCustomColors.current.secondaryButton

val ColorScheme.primaryText: Color
    @Composable
    get() = LocalCustomColors.current.primaryText
