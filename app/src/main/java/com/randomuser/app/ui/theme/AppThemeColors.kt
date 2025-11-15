package ru.project.tutor.common_ui.composable.theme

import androidx.compose.ui.graphics.Color

interface AppThemeColors {
    interface Text {
        val primary: Color
        val mask: Color
        val primaryUniform: Color
        val placeholder: Color



        val red: Color
        val blue: Color
        val reverse: Color
        val blueTwo: Color
        val whiteUniform: Color
    }

    interface Background {
        val basic: Color
        val primary: Color
        val secondary: Color
        val primaryUniform: Color




        val blue: Color
        val red: Color
        val green: Color
        val secondaryTwo: Color
        val basicUniform: Color
        val mask: Color
        val yellow: Color
    }

    val text: Text
    val background: Background
}


class AppThemeColorsSchemes(
    val dark: AppThemeColors,
    val light: AppThemeColors,
    private val current: AppThemeColors,
) : AppThemeColors by current