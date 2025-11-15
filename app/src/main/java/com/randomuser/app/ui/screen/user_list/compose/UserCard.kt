import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import ru.project.tutor.common_ui.composable.theme.AppTheme
import androidx.compose.runtime.Composable
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
            nationality = Nationality.US,
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
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(
                color = AppTheme.colors.background.secondary,
                shape = RoundedCornerShape(16.dp)
            )
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = userUi.mediumPicture,
                contentDescription = null,
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "${userUi.firstName} ${userUi.lastName}",
                    style = AppTheme.textStyle.titleTwo,
                    color = AppTheme.colors.text.primary
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = userUi.phone,
                    style = AppTheme.textStyle.titleTwo,
                    color = AppTheme.colors.text.mask
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(userUi.nationality.flagRes),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = userUi.nationality.name,
                        style = AppTheme.textStyle.titleTwo,
                        color = AppTheme.colors.text.mask
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(onClick = {
                onEvent(
                    UserListStore.Event.ShowBottomSheet(userId = userUi.userId)
                )
            }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_more_vert),
                    contentDescription = "",
                    tint = AppTheme.colors.text.primary
                )
            }
        }
    }
}