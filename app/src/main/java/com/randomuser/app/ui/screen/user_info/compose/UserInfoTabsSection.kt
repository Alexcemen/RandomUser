package com.randomuser.app.ui.screen.user_info.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randomuser.app.ui.models.enums.UserInfoTab
import com.randomuser.app.ui.screen.user_info.UserInfoStore
import ru.project.tutor.common_ui.composable.theme.AppTheme

@Preview
@Composable
private fun UserInfoTabsSectionPreview() {
    Us
}

@Composable
fun UserInfoTabsSection(
    state: UserInfoStore.UiState,
    onEvent: (UserInfoStore.Event) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                Brush.horizontalGradient(
                    listOf(
                        AppTheme.colors.background.primaryTwo,
                        AppTheme.colors.background.primary,
                    )
                )
            )
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            TabItem(
                title = "Info",
                isSelected = selectedTab == UserInfoTab.INFO,
                modifier = Modifier.weight(1f),
                onClick = { onTabClick(UserInfoTab.INFO) }
            )
            TabItem(
                title = "Phone",
                isSelected = selectedTab == UserInfoTab.PHONE,
                modifier = Modifier.weight(1f),
                onClick = { onTabClick(UserInfoTab.PHONE) }
            )
            TabItem(
                title = "Email",
                isSelected = selectedTab == UserInfoTab.EMAIL,
                modifier = Modifier.weight(1f),
                onClick = { onTabClick(UserInfoTab.EMAIL) }
            )
            TabItem(
                title = "Location",
                isSelected = selectedTab == UserInfoTab.LOCATION,
                modifier = Modifier.weight(1f),
                onClick = { onTabClick(UserInfoTab.LOCATION) }
            )
        }
    }
}

@Composable
private fun TabItem(
    title: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(24.dp))
            .background(
                if (isSelected) Color.White else Color.Transparent
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            // подставь свои стили и цвета
            style = AppTheme.textStyle.subheadThree,
            color = if (isSelected) AppTheme.colors.background.primary
            else Color.White
        )
    }
}