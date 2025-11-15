package com.randomuser.app.ui.screen.create_user.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.randomuser.app.R
import ru.project.tutor.common_ui.composable.theme.AppTheme


@Preview
@Composable
private fun SelectorFieldPreview() {
    SelectorField(
        value = "Male",
        options = listOf("nale"),
    ) { }
}


@Composable
fun SelectorField(
    value: String,
    options: List<String>,
    onValueSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = {},
        readOnly = true,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = true },
        trailingIcon = {
            Image(
                painter = painterResource(id = R.drawable.id_polygon),
                contentDescription = "back",
                colorFilter = ColorFilter.tint(color = AppTheme.colors.background.mask),
            )
        }
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        options.forEach { option ->
            DropdownMenuItem(
                text = {
                    Text(
                        text = option,
                        style = AppTheme.textStyle.titleTwo,
                        color = AppTheme.colors.text.mask,
                    )
                },
                onClick = {
                    onValueSelected(option)
                    expanded = false
                }
            )
        }
    }
}