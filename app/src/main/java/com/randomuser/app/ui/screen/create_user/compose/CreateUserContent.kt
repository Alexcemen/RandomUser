package com.randomuser.app.ui.screen.create_user.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randomuser.app.ui.screen.create_user.CreateUserStore
import com.randomuser.app.ui.models.enums.Gender
import com.randomuser.app.ui.models.enums.Nationality
import com.randomuser.app.utils.composable_elements.BottomSpacerSystem
import com.randomuser.app.utils.composable_elements.ContainerContent
import com.randomuser.app.utils.composable_elements.MainToolbar
import com.randomuser.app.utils.composable_elements.PrimaryButton
import com.randomuser.app.utils.composable_elements.SpacerHeight
import com.randomuser.app.R
import ru.project.tutor.common_ui.composable.theme.AppTheme


@Preview(
    name = "Light",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun CreateUserContentPreviewLight() {
    AppTheme(themeDark = false) {
        CreateUserContent(
            state = CreateUserStore.UiState(
                gender = Gender.MALE,
                nationality = Nationality.UA
            ),
            onEvent = {}
        )
    }
}

@Preview(
    name = "Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun CreateUserContentPreviewDark() {
    AppTheme(themeDark = true) {
        CreateUserContent(
            state = CreateUserStore.UiState(
                gender = Gender.MALE,
                nationality = Nationality.UA
            ),
            onEvent = {}
        )
    }
}

@Composable
fun CreateUserContent(
    state: CreateUserStore.UiState,
    onEvent: (CreateUserStore.Event) -> Unit,
) {
    ContainerContent(
        topBar = {
            MainToolbar(
                text = stringResource(R.string.title_create_user_content),
                isVisibleBack = true,
                onClickBack = {
                    onEvent(
                        CreateUserStore.Event.Close
                    )
                }
            )
        }
    ) {
        Column(Modifier.weight(1f)) {
            SpacerHeight(42.dp)
            Text(
                text = stringResource(R.string.select_gender),
                style = AppTheme.textStyle.titleTwo,
                color = AppTheme.colors.text.primary,
            )
            SpacerHeight(24.dp)
            SelectorField(
                value = state.gender.title,
                options = Gender.entries.map { it.title },
                onValueSelected = { selected ->
                    val gender = Gender.entries.first { it.title == selected }
                    onEvent(
                        CreateUserStore.Event.SelectedGender(gender)
                    )
                }
            )
            SpacerHeight(32.dp)
            Text(
                text = stringResource(R.string.select_nationality),
                style = AppTheme.textStyle.titleTwo,
                color = AppTheme.colors.text.primary,
            )
            SpacerHeight(24.dp)
            SelectorField(
                value = state.nationality.title,
                options = Nationality.entries.map { it.title },
                onValueSelected = { selected ->
                    val nationality = Nationality.entries.first { it.title == selected }
                    onEvent(
                        CreateUserStore.Event.SelectedNationality(nationality)
                    )
                }
            )
        }
        SpacerHeight(16.dp)
        PrimaryButton(text = stringResource(R.string.generate)) {
            onEvent(
                CreateUserStore.Event.Generate
            )
        }
        BottomSpacerSystem()
        SpacerHeight(16.dp)
    }
}