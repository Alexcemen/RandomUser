package com.randomuser.app.ui.screen.create_user.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
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

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = AppTheme.colors.background.primaryUniform,
                    shape = RoundedCornerShape(4.dp)
                )
                .background(
                    color = AppTheme.colors.background.secondary,
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable { expanded = !expanded }
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = value,
                    style = AppTheme.textStyle.titleThree,
                    color = AppTheme.colors.text.primaryUniform,
                    modifier = Modifier.weight(1f)
                )

                Image(
                    painter = painterResource(R.drawable.id_polygon),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(color = AppTheme.colors.background.primaryUniform),
                    modifier = Modifier
                        .graphicsLayer {
                            rotationZ = if (expanded) 180f else 0f
                        }
                        .clickable { expanded = !expanded }
                )
            }
        }

        if (expanded) {
            DropdownList(
                options = options,
                onSelect = {
                    onValueSelected(it)
                    expanded = false
                }
            )
        }
    }
}

@Composable
private fun DropdownList(
    options: List<String>,
    onSelect: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = AppTheme.colors.background.primaryUniform,
                shape = RoundedCornerShape(
                    bottomStart = 8.dp,
                    bottomEnd = 8.dp
                )
            )
            .background(
                color = AppTheme.colors.background.secondary,
                shape = RoundedCornerShape(
                    bottomStart = 8.dp,
                    bottomEnd = 8.dp
                )
            )
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            options.forEachIndexed { index, option ->
                Text(
                    text = option,
                    style = AppTheme.textStyle.defaultLight,
                    color = AppTheme.colors.text.primaryUniform,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSelect(option) }
                        .padding(12.dp)
                )

                if (index < options.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .height(1.dp),
                        color = AppTheme.colors.background.primaryUniform
                    )
                }
            }
        }
    }
}
