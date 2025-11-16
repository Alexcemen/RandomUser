package com.randomuser.app.ui.screen.user_list.compose

import UserCard
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randomuser.app.R
import com.randomuser.app.ui.models.UserUi
import com.randomuser.app.ui.models.enums.Nationality
import com.randomuser.app.ui.screen.user_list.UserListStore
import com.randomuser.app.utils.composable_elements.ContainerContent
import com.randomuser.app.utils.composable_elements.SpacerHeight
import com.randomuser.app.utils.composable_elements.TopBarSpacer
import ru.project.tutor.common_ui.composable.theme.AppTheme

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
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        ContainerContent() {
            TopBarSpacer()
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(state.users) {
                    SpacerHeight(8.dp)
                    UserCard(
                        userUi = it,
                        onEvent = onEvent
                    )
                }
            }
        }
        AddUserBottom(
            onClick = {
                onEvent(
                    UserListStore.Event.AddUser
                )
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )
    }
}

@Composable
fun AddUserBottom(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(56.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(AppTheme.colors.background.primary)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_plus),
            contentDescription = "",
            colorFilter = ColorFilter.tint(AppTheme.colors.background.basic)
        )
    }
}
