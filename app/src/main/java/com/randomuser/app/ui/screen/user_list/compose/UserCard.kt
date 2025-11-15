import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import ru.project.tutor.common_ui.composable.theme.AppTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.randomuser.app.ui.models.UserUi
import com.randomuser.app.ui.models.enums.Nationality
import com.randomuser.app.ui.screen.user_list.UserListStore
import com.randomuser.app.R


@Preview
@Composable
private fun UserCardPreview() {
    UserCard(
        userUi = UserUi(
            userId = 1,
            firstName = "Troy",
            lastName = "Ramirez",
            phone = "(464) 445-5537",
            nationality = Nationality.UA,
            mediumPicture = "https://randomuser.me/api/portraits/women/67.jpg"
        ),
        {}
    )
}


@Composable
fun UserCard(
    userUi: UserUi,
    onEvent: (UserListStore.Event) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false
            )
            .background(
                color = AppTheme.colors.background.secondary,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, top = 14.dp, bottom = 14.dp, end = 20.dp),
            verticalAlignment = Alignment.Top
        ) {
            AsyncImage(
                model = userUi.mediumPicture,
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "${userUi.firstName} ${userUi.lastName}",
                    style = AppTheme.textStyle.titleThree1,
                    color = AppTheme.colors.text.primary
                )

                Text(
                    text = userUi.phone,
                    style = AppTheme.textStyle.headline,
                    color = AppTheme.colors.text.placeholder
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(userUi.nationality.flagRes),
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                        )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = userUi.nationality.name,
                        style = AppTheme.textStyle.headline,
                        color = AppTheme.colors.text.placeholder
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.ic_more_vert),
                contentDescription = "",
                colorFilter = ColorFilter.tint(color = AppTheme.colors.background.primary),
                modifier = Modifier
                    .padding(top = 4.dp)
                    .clickable {
                    onEvent(
                        UserListStore.Event.ShowBottomSheet(userId = userUi.userId)
                    )
                },
            )
        }
    }
}