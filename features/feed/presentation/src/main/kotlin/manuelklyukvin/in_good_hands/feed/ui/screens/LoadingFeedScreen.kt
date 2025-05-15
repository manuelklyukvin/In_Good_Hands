package manuelklyukvin.in_good_hands.feed.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.components.MKUILoadingItem
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme
import manuelklyukvin.in_good_hands.feed.ui.utils.FeedScreenParams
import manuelklyukvin.in_good_hands.feed.ui.view_models.models.FeedState

@Composable
internal fun LoadingFeedScreen(state: FeedState) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = MKUITheme.shapes.screenPadding)
            .clip(MKUITheme.shapes.roundedCornerShape),
        columns = GridCells.Fixed(state.columnCount),
        verticalArrangement = Arrangement.spacedBy(MKUITheme.shapes.paddingSmall),
        horizontalArrangement = Arrangement.spacedBy(MKUITheme.shapes.paddingSmall),
        userScrollEnabled = false
    ) {
        items(state.columnCount * 10) {
            MKUILoadingItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(FeedScreenParams.POST_HEIGHT)
            )
        }
    }
}

@Preview
@Composable
private fun LightLoadingFeedScreenPreview() {
    LoadingFeedScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkLoadingFeedScreenPreview() {
    LoadingFeedScreenPreview()
}

@Composable
private fun LoadingFeedScreenPreview() {
    MKUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MKUITheme.colorScheme.background
        ) {
            LoadingFeedScreen(FeedState(columnCount = 2))
        }
    }
}