package com.randomuser.app.ui.screen.user_info.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randomuser.app.R
import com.randomuser.app.ui.models.LocationUi
import com.randomuser.app.ui.models.StreetUi
import com.randomuser.app.ui.models.UserInfoUi
import com.randomuser.app.ui.models.enums.UserInfoTab
import ru.project.tutor.common_ui.composable.theme.AppTheme

@Preview
@Composable
private fun UserInfoContentCardPreview() {
    UserInfoContentCard(
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
        selectedUserInfoTab = UserInfoTab.INFO
    )
}


@Composable
fun UserInfoContentCard(
    user: UserInfoUi,
    selectedUserInfoTab: UserInfoTab,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
            .background(AppTheme.colors.background.secondary)
            .padding(20.dp)
    ) {
        when (selectedUserInfoTab) {
            UserInfoTab.INFO -> InfoContent(user)
            UserInfoTab.PHONE -> PhoneContent(user)
            UserInfoTab.EMAIL -> EmailContent(user)
            UserInfoTab.LOCATION -> LocationContent(user)
        }
    }
}

@Composable
fun InfoContent(
    user: UserInfoUi,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        InfoRow(
            label = stringResource(R.string.first_name),
            value = user.firstName
        )
        InfoRow(
            label = stringResource(R.string.last_name),
            value = user.lastName
        )
        InfoRow(
            label = stringResource(R.string.gender),
            value = user.gender
        )
        InfoRow(
            label = stringResource(R.string.age),
            value = user.age.toString()
        )
        InfoRow(
            label = stringResource(R.string.date_of_birth),
            value = user.dateOfBirth
        )
    }
}

@Composable
fun PhoneContent(user: UserInfoUi) {
    InfoRow(
        label = stringResource(R.string.phone),
        value = user.phone
    )
}

@Composable
fun EmailContent(user: UserInfoUi) {
    InfoRow(
        label = stringResource(R.string.email),
        value = user.email
    )
}

@Composable
fun LocationContent(user: UserInfoUi) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        InfoRow(
            label = stringResource(R.string.country),
            value = user.location.country
        )
        InfoRow(
            label = stringResource(R.string.state),
            value = user.location.state
        )
        InfoRow(
            label = stringResource(R.string.city),
            value = user.location.city
        )
        InfoRow(
            label = stringResource(R.string.street),
            value = "${user.location.street.name} ${user.location.street.number}"
        )
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row {
        Text(
            text = label,
            style = AppTheme.textStyle.titleThree1,
            color = AppTheme.colors.text.primary
        )
        Text(
            text = value,
            style = AppTheme.textStyle.defaultNorm,
            color = AppTheme.colors.text.mask
        )
    }
}