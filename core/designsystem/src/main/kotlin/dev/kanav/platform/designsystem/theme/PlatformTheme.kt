package dev.kanav.platform.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PlatformColorScheme = lightColorScheme(
    primary = Color(0xFF1B2A4A),
    secondary = Color(0xFF3D5A80),
    tertiary = Color(0xFF98C1D9),
    background = Color(0xFFF8FAFC),
    surface = Color(0xFFFFFFFF),
)

@Composable
fun PlatformTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = PlatformColorScheme,
        content = content,
    )
}
