package com.randomuser.app.ui.screen.user_info.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randomuser.app.utils.composable_elements.SpacerHeight
import ru.project.tutor.common_ui.composable.theme.AppTheme

@Preview
@Composable
private fun GreetingSectionPreview() {
    GreetingSection(
        firstName = "Ritthy",
        lastName = "Lopez"
    )
}


@Composable
fun GreetingSection(
    firstName: String,
    lastName: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Text(
            text = "Hi how are you today?\nI'm",
            style = AppTheme.textStyle.defaultNorm,
            color = AppTheme.colors.text.mask,
            textAlign = TextAlign.Center
        )

        SpacerHeight(8.dp)


        Text(
            text = "$firstName $lastName",
            style = AppTheme.textStyle.titleTwo,
            color = AppTheme.colors.text.primary
        )
    }
}