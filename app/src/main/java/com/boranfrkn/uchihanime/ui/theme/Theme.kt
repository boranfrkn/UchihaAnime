package com.boranfrkn.uchihanime.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.boranfrkn.uchihanime.UchihaAnime

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Purple200,
    onBackground = Purple200,
    onPrimary = Purple200
)

private val LightColorPalette = lightColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Purple200,
    onBackground = Purple500,
    onPrimary = Purple500,
    onSecondary = Purple500,
    onSurface = Purple500,
    surface = Purple500,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun UchihaAnimeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}