package com.randomuser.app.ui.screen.user_list.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.randomuser.app.ui.models.UserUi
import com.randomuser.app.ui.models.enums.Nationality
import com.randomuser.app.ui.screen.user_list.UserListStore

@Preview
@Composable
private fun UserListContentPreview() {
    UserListContent(
        state = UserListStore.UiState(
            listOf(
                UserUi(
                    userId = 1,
                    firstName = "Gabrielle",
                    lastName = "Gautheir",
                    phone = "Y26 B17-2963",
                    nationality = Nationality.CA,
                    mediumPicture = ""
                ),
                UserUi(
                    userId = 2,
                    firstName = "Troy",
                    lastName = "Ramirez",
                    phone = "(464) 445-5537",
                    nationality = Nationality.US,
                    mediumPicture = ""
                ),
                UserUi(
                    userId = 3,
                    firstName = "Ritthy",
                    lastName = "Lopez",
                    phone = "(294) 785-6098",
                    nationality = Nationality.US,
                    mediumPicture = ""
                )
            )
        ),
        {}
    )
}

@Composable
fun UserListContent(
    state: UserListStore.UiState,
    onEvent: (UserListStore.Event) -> Unit,
) {

}