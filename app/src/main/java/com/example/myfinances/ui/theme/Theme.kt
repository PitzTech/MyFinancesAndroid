package com.example.myfinances.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

data class CustomColors(
    val primaryButton: Color,
    val secondaryButton: Color,
    val primaryText: Color
)

private val DarkColorScheme = darkColorScheme(
    primary = White40,
    secondary = Blue80,
    tertiary = Green40,
    
    error = Red40,

    background = Blue80,
)

private val LightColorScheme = lightColorScheme(
    primary = White40,
    secondary = Blue80,
    tertiary = Green40,

    error = Red40,

    background = Blue80,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        primaryButton = Green80,
        secondaryButton = Green40,
        primaryText = White40
    )
}

@Composable
fun MyFinancesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val customColors = if (darkTheme) {
        CustomColors(
            primaryButton = Green80,
            secondaryButton = Green40,
            primaryText = White40
        )
    } else {
        CustomColors(
            primaryButton = Green80,
            secondaryButton = Green40,
            primaryText = White40
        )
    }

    CompositionLocalProvider(LocalCustomColors provides customColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}