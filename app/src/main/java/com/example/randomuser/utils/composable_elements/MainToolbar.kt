package com.example.randomuser.utils.composable_elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.randomuser.app.R
import ru.project.tutor.common_ui.composable.theme.AppTheme

@Composable
@Preview
internal fun MainToolbarPreview() {
    MainToolbar(text = "Title")
}

@Composable
fun MainToolbar(
    text: String,
    applyStatusBarInsets: Boolean = true,
    isVisibleBack: Boolean = true,
    backgroundColor: Color = AppTheme.colors.background.basic,
    onClickBack: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ) {
        if (applyStatusBarInsets) {
            Spacer(
                modifier = Modifier.height(
                    WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
                )
            )
        }
        ContentToolBar(text = text, isVisibleBack = isVisibleBack, onClickBack = onClickBack)
    }
}


@Composable
private fun ContentToolBar(
    text: String,
    isVisibleBack: Boolean,
    padding: Dp = 16.dp,
    onClickBack: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        if (isVisibleBack) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = "back",
                colorFilter = ColorFilter.tint(color = AppTheme.colors.background.primary),
                modifier = Modifier
                    .padding(start = padding)
                    .size(20.dp)
                    .align(Alignment.CenterStart)
                    .clickable { onClickBack() },
            )
        }
        Text(
            text = text,
            style = AppTheme.textStyle.titleOne,
            color = AppTheme.colors.text.primary,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}