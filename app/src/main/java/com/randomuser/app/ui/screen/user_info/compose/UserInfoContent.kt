package com.randomuser.app.ui.screen.user_info.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randomuser.app.ui.models.LocationUi
import com.randomuser.app.ui.models.StreetUi
import com.randomuser.app.ui.models.UserInfoUi
import com.randomuser.app.ui.models.enums.UserInfoTab
import com.randomuser.app.ui.screen.user_info.UserInfoStore
import com.randomuser.app.utils.composable_elements.ContainerContent
import com.randomuser.app.utils.composable_elements.SpacerHeight
import com.randomuser.app.utils.composable_elements.TopBarSpacer

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
    ContainerContent(
        applyHorizontalPadding = false
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
        UserInfoTabsSection(
            user = state.user,
            selectedUserInfoTab = state.selectedTab,
            onEvent = onEvent
        )
    }
}