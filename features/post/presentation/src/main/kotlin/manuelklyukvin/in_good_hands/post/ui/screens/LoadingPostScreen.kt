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
import manuelklyukvin.in_good_hands.core.ui.components.MKUILoadingItem
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme
import manuelklyukvin.in_good_hands.post.ui.utils.PostScreenParams

@Composable
internal fun LoadingPostScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = MKUITheme.shapes.screenPadding)
            .clip(MKUITheme.shapes.roundedCornerShape),
        verticalArrangement = Arrangement.spacedBy(MKUITheme.shapes.paddingSmall)
    ) {
        repeat(3) {
            MKUILoadingItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(PostScreenParams.IMAGE_HEIGHT)
            )
        }
    }
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
    MKUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MKUITheme.colorScheme.background
        ) {
            LoadingPostScreen()
        }
    }
}