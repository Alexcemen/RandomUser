package ru.project.tutor.common_ui.composable.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
object LightText : AppThemeColors.Text {
    override val primary: Color
        get() = Color(0xFF103264)
    override val mask: Color
        get() = Color(0xFF46414B)
    override val primaryUniform: Color
        get() = Color(0xFF1C1C1C)
    override val placeholder: Color
        get() = Color(0xFF9C9C9C)
    override val reverse: Color
        get() = Color(0xFFFBFBFB)
}

@Immutable
object LightBackground : AppThemeColors.Background {
    override val basic: Color
        get() = Color(0xFFFFFFFF)
    override val primary: Color
        get() = Color(0xFF103264)
    override val mask: Color
        get() = Color(0xFF46414B)
    override val secondary: Color
        get() = Color(0xFFFBFBFB)
    override val primaryUniform: Color
        get() = Color(0xFF1C1C1C)
    override val primaryTwo: Color
        get() = Color(0xFF5B82B4)
    override val secondaryTwo: Color
        get() = Color(0xFFF9F9F9)
}

object LightColor : AppThemeColors {
    override val text: AppThemeColors.Text = LightText
    override val background: AppThemeColors.Background = LightBackground
}