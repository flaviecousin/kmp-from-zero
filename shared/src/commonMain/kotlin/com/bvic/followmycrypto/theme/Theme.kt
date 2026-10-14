package com.bvic.followmycrypto.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// Ancien thème
/*private val DarkColorScheme = darkColorScheme(
    primary = Gold,
    onPrimary = Ink,
    secondaryContainer = GoldDeep,
    onSecondaryContainer = Gold,
    background = Ink,
    onBackground = Snow,
    surface = Ink,
    onSurface = Snow,
    onSurfaceVariant = Slate,
    surfaceContainerLowest = Ink,
    surfaceContainerLow = Night,
    surfaceContainer = Night,
    surfaceContainerHigh = NightContainer,
    surfaceContainerHighest = NightContainerHigh,
    outlineVariant = NightContainerHigh,
)

private val LightColorScheme = lightColorScheme(
    primary = Gold,
    onPrimary = Ink,
    secondaryContainer = GoldSoft,
    onSecondaryContainer = Ink,
    background = Mist,
    onBackground = Ink,
    surface = Mist,
    onSurface = Ink,
    onSurfaceVariant = Slate,
    surfaceContainerLowest = Snow,
    surfaceContainerLow = Snow,
    surfaceContainer = Snow,
    surfaceContainerHigh = Cloud,
    surfaceContainerHighest = Cloud,
    outlineVariant = Cloud,
)*/

// Nouveau thème
private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkBackground,
    secondaryContainer = DarkAccent,
    onSecondaryContainer = DarkBackground,
    background = DarkBackground,
    onBackground = LightSurface,
    surface = DarkSurface,
    onSurface = LightSurface,
    onSurfaceVariant = DarkAccent,
    surfaceContainerLowest = DarkBackground,
    surfaceContainerLow = DarkBackground,
    surfaceContainer = DarkBackground,
    surfaceContainerHigh = DarkBackground,
    surfaceContainerHighest = DarkBackground,
    outlineVariant = DarkSurface,
    tertiary = DarkSuccess,
    error = DarkError,
    onError = DarkBackground
)

private val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightSurface,
    secondaryContainer = LightPrimary,
    onSecondaryContainer = LightSurface,
    background = LightBackground,
    onBackground = DarkBackground,
    surface = LightBackground,
    onSurface = DarkBackground,
    onSurfaceVariant = DarkSurface,
    surfaceContainerLowest = LightBackground,
    surfaceContainerLow = LightBackground,
    surfaceContainer = LightBackground,
    surfaceContainerHigh = LightBackground,
    surfaceContainerHighest = LightBackground,
    outlineVariant = LightBackground,
    tertiary = LightSuccess,
    error = LightError,
    onError = LightSurface
)

@Composable
fun FollowMyCryptoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        content = content,
    )
}
