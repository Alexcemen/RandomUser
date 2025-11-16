package com.randomuser.app.ui.screen.user_info.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.randomuser.app.ui.models.UserUi
import com.randomuser.app.ui.models.enums.Nationality
import com.randomuser.app.ui.screen.user_info.UserInfoStore
import com.randomuser.app.utils.composable_elements.ContainerContent

@Preview
@Composable
private fun UserInfoContentPreview() {
    UserInfoContent(
        state = UserInfoStore.UiState(
            user = UserUi(
                userId = 1,
                firstName = "Troy",
                lastName = "Ramirez",
                phone = "(464) 445-5537",
                nationality = Nationality.UA,
                mediumPicture = "https://randomuser.me/api/portraits/women/67.jpg"
            )
        ),
        {}
    )
}

@Composable
fun UserInfoContent(
    state: UserInfoStore.UiState,
    onEvent: (UserInfoStore.Event) -> Unit
) {
    ContainerContent {

    }
}