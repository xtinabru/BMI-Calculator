package com.example.bodymassindexcalculator.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bodymassindexcalculator.R


private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF8A4F96),
    secondary = Color(0xFF6A3D85),
    background = Color(0xFF1C1C1C),
    surface = Color(0xFF2A2A2A),
    onPrimary = Color.White,
    onBackground = Color(0xFFE0E0E0),
    onSurface = Color(0xFFE0E0E0),
    error = Color(0xFFCF6679)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFC65893),
    primaryContainer = Color(0xFFF3D1D9),
    background = Color(0xFFebd6b4),
    onBackground = Color(0xFFC65893),
    surface = Color(0xFFC65893),
    onSurface = Color(0xFFFFF5F5),
    error = Color(0xFFC65893)
)


val defaultFontFamily = FontFamily.Default

val headerTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.playfair_display)),
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    color = Color(0xFF28282A)
)

val bodyTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto)),
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    color = Color(0xFF28282A)
)

val accentTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.playfair_display)),
    fontWeight = FontWeight.Normal,
    fontSize = 18.sp,
    color = Color(0xFF9852268)
)

@Composable
fun BodyMassIndexCalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = MaterialTheme.typography.copy(
            titleLarge = headerTextStyle,
            bodyLarge = bodyTextStyle,
            titleMedium = accentTextStyle
        ),
        content = content
    )
}