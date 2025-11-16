package ru.project.tutor.common_ui.composable.theme

import androidx.compose.ui.graphics.Color

interface AppThemeColors {
    interface Text {
        val primary: Color
        val mask: Color
        val primaryUniform: Color
        val placeholder: Color
        val reverse: Color
    }

    interface Background {
        val basic: Color
        val primary: Color
        val secondary: Color
        val primaryUniform: Color
        val primaryTwo: Color
        val secondaryTwo: Color
        val mask: Color
    }

    val text: Text
    val background: Background
}


class AppThemeColorsSchemes(
    val dark: AppThemeColors,
    val light: AppThemeColors,
    private val current: AppThemeColors,
) : AppThemeColors by current