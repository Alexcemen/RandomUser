package com.randomuser.app.ui.screen.user_info.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randomuser.app.R
import com.randomuser.app.ui.models.LocationUi
import com.randomuser.app.ui.models.StreetUi
import com.randomuser.app.ui.models.UserInfoUi
import com.randomuser.app.ui.models.enums.UserInfoTab
import com.randomuser.app.ui.screen.user_info.UserInfoStore
import ru.project.tutor.common_ui.composable.theme.AppTheme

@Preview
@Composable
private fun UserInfoTabsSectionPreview() {
    UserInfoTabsSection(
        user = UserInfoUi(
            firstName = "Liam",
            lastName = "Hughes",
            gender = "male",
            age = 31,
            dateOfBirth = "1993-07-12",
            phone = "(219) 292-4832",
            email = "liam.hughes@example.com",
            location = LocationUi(
                country = "Canada",
                state = "Ontario",
                city = "Sudbury",
                street = StreetUi(
                    name = "Station Road",
                    number = 8421
                ),
                postcode = "postcode"
            ),
            picture = ""
        ),
        selectedUserInfoTab = UserInfoTab.INFO,
        {}
    )
}

@Composable
fun UserInfoTabsSection(
    user: UserInfoUi,
    selectedUserInfoTab: UserInfoTab,
    onEvent: (UserInfoStore.Event) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
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
                iconId = R.drawable.ic_person,
                isSelected = selectedUserInfoTab == UserInfoTab.INFO,
                modifier = Modifier.weight(1f),
                onClick = {
                    onEvent(
                        UserInfoStore.Event.OnTabClick(UserInfoTab.INFO)
                    )
                }
            )
            TabItem(
                iconId = R.drawable.ic_phone,
                isSelected = selectedUserInfoTab == UserInfoTab.PHONE,
                modifier = Modifier.weight(1f),
                onClick = {
                    onEvent(
                        UserInfoStore.Event.OnTabClick(UserInfoTab.PHONE)
                    )
                }
            )
            TabItem(
                iconId = R.drawable.ic_dog,
                isSelected = selectedUserInfoTab == UserInfoTab.EMAIL,
                modifier = Modifier.weight(1f),
                onClick = {
                    onEvent(
                        UserInfoStore.Event.OnTabClick(UserInfoTab.EMAIL)
                    )
                }
            )
            TabItem(
                iconId = R.drawable.ic_location,
                isSelected = selectedUserInfoTab == UserInfoTab.LOCATION,
                modifier = Modifier.weight(1f),
                onClick = {
                    onEvent(
                        UserInfoStore.Event.OnTabClick(UserInfoTab.LOCATION)
                    )
                }
            )
        }
    }
}

@Composable
private fun TabItem(
    iconId: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(
                if (isSelected) Color.White else Color.Transparent
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = "back",
            colorFilter = ColorFilter.tint(
                color = if (isSelected) AppTheme.colors.background.primaryUniform
                else AppTheme.colors.background.basic),
            modifier = Modifier
                .size(30.dp)
        )
    }
}