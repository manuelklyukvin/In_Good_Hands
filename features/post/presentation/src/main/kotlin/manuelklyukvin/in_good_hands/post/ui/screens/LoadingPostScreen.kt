package manuelklyukvin.in_good_hands.post.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import manuelklyukvin.in_good_hands.core.ui.components.AppLoadingItem
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme
import manuelklyukvin.in_good_hands.post.ui.utils.PostScreenParams

@Composable
internal fun LoadingPostScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppTheme.shapes.screenPadding)
            .clip(AppTheme.shapes.roundedCornerShape),
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall)
    ) {
        LoadingImagePager()
        LoadingPostInfo()
        LoadingUserInfo()
    }
}

@Composable
private fun LoadingImagePager() {
    AppLoadingItem(
        modifier = Modifier
            .fillMaxWidth()
            .height(PostScreenParams.IMAGE_HEIGHT)
    )
}

@Composable
private fun LoadingPostInfo() {
    AppLoadingItem(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    )
}

@Composable
private fun LoadingUserInfo() {
    AppLoadingItem(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    )
}

@Preview
@Composable
private fun LightLoadingPostScreenPreview() {
    LoadingPostScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkLoadingPostScreenPreview() {
    LoadingPostScreenPreview()
}

@Composable
private fun LoadingPostScreenPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            LoadingPostScreen()
        }
    }
}