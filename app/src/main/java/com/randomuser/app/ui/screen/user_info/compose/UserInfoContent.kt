package com.randomuser.app.ui.screen.user_info.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.randomuser.app.ui.models.enums.UserInfoTab
import com.randomuser.app.ui.screen.user_info.UserInfoStore
import com.randomuser.app.utils.composable_elements.ContainerContent
import com.randomuser.app.utils.composable_elements.TopBarSpacer
import com.randomuser.domain.model.Coordinates
import com.randomuser.domain.model.Dob
import com.randomuser.domain.model.Location
import com.randomuser.domain.model.Login
import com.randomuser.domain.model.Name
import com.randomuser.domain.model.Picture
import com.randomuser.domain.model.Registered
import com.randomuser.domain.model.Street
import com.randomuser.domain.model.Timezone
import com.randomuser.domain.model.User
import com.randomuser.domain.model.UserId

@Preview
@Composable
private fun UserInfoContentPreview() {
    UserInfoContent(
        state = UserInfoStore.UiState(
            user = User(
                localId = 1,
                gender = "male",
                name = Name(
                    title = "Mr",
                    first = "Liam",
                    last = "Hughes"
                ),
                location = Location(
                    street = Street(
                        number = 8421,
                        name = "Station Road"
                    ),
                    city = "Sudbury",
                    state = "Ontario",
                    country = "Canada",
                    postcode = "P3A 2A7",
                    coordinates = Coordinates(
                        latitude = "",
                        longitude = ""
                    ),
                    timezone = Timezone(
                        offset = "",
                        description = ""
                    )
                ),
                email = "liam.hughes@gmail.com",
                login = Login(
                    uuid = "",
                    username = "",
                    password = "",
                    salt = "",
                    md5 = "",
                    sha1 = "",
                    sha256 = ""
                ),
                dob = Dob(
                    date = "1993-07-12",
                    age = 31
                ),
                registered = Registered(
                    date = "",
                    age = 0
                ),
                phone = "(219) 292-4832",
                cell = "",
                userId = UserId(
                    name = "",
                    value = ""
                ),
                picture = Picture(
                    large = "",
                    medium = "",
                    thumbnail = ""
                ),
                nat = "CA"
            ),
            selectedTab = UserInfoTab.INFO
        ),
        {}
    )
}

@Composable
fun UserInfoContent(
    state: UserInfoStore.UiState,
    onEvent: (UserInfoStore.Event) -> Unit
) {
    ContainerContent(
        applyHorizontalPadding = false
    ) {
        TopBarSpacer()
        HeaderSection(
            photoUrl = state.user.picture.medium,
            onBackClick = {
                onEvent(
                    UserInfoStore.Event.Close
                )
            }
        )
        GreetingSection(
            firstName = state.user.name.first,
            lastName = state.user.name.last
        )
    }
}