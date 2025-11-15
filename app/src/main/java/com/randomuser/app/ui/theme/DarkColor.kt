package ru.project.tutor.common_ui.composable.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
object DarkText : AppThemeColors.Text {
    override val primary: Color
        get() = Color(0xFFFFFFFF)
    override val mask: Color
        get() = Color(0xFFCCCCCC)
    override val primaryUniform: Color
        get() = Color(0xFF1C1C1C)
    override val placeholder: Color
        get() = Color(0xFFA6A6A6)

    override val red: Color
        get() = Color(0xFFE67474)
    override val blue: Color
        get() = Color(0xFF588BD4)

    override val reverse: Color
        get() = Color(0xFF000000)
    override val blueTwo: Color
        get() = Color(0xFF4987C5)
    override val whiteUniform: Color
        get() = Color(0xFFFFFFFF)
}

@Immutable
object DarkBackground : AppThemeColors.Background {
    override val basic: Color
        get() = Color(0xFF3A3B3E)
    override val primary: Color
        get() = Color(0xFFF6F6F6)
    override val mask: Color
        get() = Color(0xFF8F8F8F)
    override val secondary: Color
        get() = Color(0xFFE3E3E3)
    override val primaryUniform: Color
        get() = Color(0xFF1C1C1C)


    override val blue: Color
        get() = Color(0xFF2B4976)
    override val red: Color
        get() = Color(0xFF762B2B)
    override val green: Color
        get() = Color(0xFF19582D)
    override val secondaryTwo: Color
        get() = Color(0xFF3F3F3F)
    override val basicUniform: Color
        get() = Color(0xFFFFFFFF)

    override val yellow: Color
        get() = Color(0xFFA68E0F)
}

object DarkColor : AppThemeColors {
    override val text: AppThemeColors.Text = DarkText
    override val background: AppThemeColors.Background = DarkBackground
}