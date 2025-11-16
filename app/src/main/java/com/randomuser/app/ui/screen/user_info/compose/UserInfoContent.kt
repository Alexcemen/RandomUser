package com.randomuser.app.ui.screen.user_info.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randomuser.app.ui.models.LocationUi
import com.randomuser.app.ui.models.StreetUi
import com.randomuser.app.ui.models.UserInfoUi
import com.randomuser.app.ui.models.enums.UserInfoTab
import com.randomuser.app.ui.screen.user_info.UserInfoStore
import com.randomuser.app.utils.composable_elements.BottomSpacerSystem
import com.randomuser.app.utils.composable_elements.SpacerHeight
import com.randomuser.app.utils.composable_elements.TopBarSpacer
import ru.project.tutor.common_ui.composable.theme.AppTheme

@Preview
@Composable
private fun UserInfoContentPreview() {
    UserInfoContent(
        state = UserInfoStore.UiState(
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
            selectedTab = UserInfoTab.INFO
        ),
        {}
    )
}

@Composable
fun UserInfoContent(
    state: UserInfoStore.UiState,
    onEvent: (UserInfoStore.Event) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background.basic)
    ) {
        TopBarSpacer()
        HeaderSection(
            photoUrl = state.user.picture,
            onBackClick = {
                onEvent(
                    UserInfoStore.Event.Close
                )
            }
        )
        SpacerHeight(90.dp)
        GreetingSection(
            firstName = state.user.firstName,
            lastName = state.user.lastName
        )
        SpacerHeight(24.dp)
        UserInfoSection(
            user = state.user,
            selectedUserInfoTab = state.selectedTab,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            onEvent = onEvent
        )
        SpacerHeight(16.dp)
        BottomSpacerSystem()
    }
}