package com.example.myfinances.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.myfinances.R

val Ubuntu = FontFamily(
        Font(R.font.ubuntu_bold, FontWeight.Bold),
        Font(R.font.ubuntu_bolditalic, FontWeight.Bold, FontStyle.Italic),

        Font(R.font.ubuntu_regular, FontWeight.Normal),
        Font(R.font.ubuntu_italic, FontWeight.Normal, FontStyle.Italic),

        Font(R.font.ubuntu_light, FontWeight.Light),
        Font(R.font.ubuntu_lightitalic, FontWeight.Light, FontStyle.Italic),

        Font(R.font.ubuntu_medium, FontWeight.Medium),
        Font(R.font.ubuntu_mediumitalic, FontWeight.Medium, FontStyle.Italic),
)
