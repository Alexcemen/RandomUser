package com.randomuser.app.ui.screen.user_info.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.randomuser.app.R
import ru.project.tutor.common_ui.composable.theme.AppTheme

@Preview
@Composable
private fun HeaderSectionPreview() {
    HeaderSection(
        photoUrl = "",
        onBackClick = {}
    )
}

@Composable
fun HeaderSection(
    photoUrl: String,
    onBackClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                Brush.horizontalGradient(
                    listOf(
                        AppTheme.colors.background.primaryTwo,
                        AppTheme.colors.background.primary,
                    )
                )
            )
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_arrow_circle),
            contentDescription = "back",
            colorFilter = ColorFilter.tint(AppTheme.colors.background.basic),
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .size(32.dp)
                .align(Alignment.TopStart)
                .clickable { onBackClick() }

        )

        AsyncImage(
            model = photoUrl,
            contentDescription = "User Image",
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.BottomCenter)
                .offset(y = 75.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}