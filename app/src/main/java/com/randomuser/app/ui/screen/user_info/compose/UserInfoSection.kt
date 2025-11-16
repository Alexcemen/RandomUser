package com.randomuser.app.ui.screen.user_info.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randomuser.app.ui.models.LocationUi
import com.randomuser.app.ui.models.StreetUi
import com.randomuser.app.ui.models.UserInfoUi
import com.randomuser.app.ui.models.enums.UserInfoTab
import com.randomuser.app.ui.screen.user_info.UserInfoStore
import ru.project.tutor.common_ui.composable.theme.AppTheme

@Preview
@Composable
private fun UserInfoSectionPreview() {
    UserInfoSection(
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
        onEvent = {},
        modifier = Modifier,
    )
}

@Composable
fun UserInfoSection(
    user: UserInfoUi,
    selectedUserInfoTab: UserInfoTab,
    modifier: Modifier,
    onEvent: (UserInfoStore.Event) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(24.dp))
            .clip(RoundedCornerShape(24.dp))
            .background(AppTheme.colors.background.secondary)
    ) {
        Column() {
            UserInfoTabs(
                selectedUserInfoTab = selectedUserInfoTab,
                onEvent = onEvent
            )
            UserInfoContentCard(
                user = user,
                selectedUserInfoTab = selectedUserInfoTab,
            )
        }
    }
}