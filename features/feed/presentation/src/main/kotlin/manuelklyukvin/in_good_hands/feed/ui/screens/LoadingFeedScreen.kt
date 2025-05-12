package manuelklyukvin.in_good_hands.feed.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import manuelklyukvin.in_good_hands.core.ui.components.AppCard
import manuelklyukvin.in_good_hands.core.ui.components.AppLoadingItem
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme
import manuelklyukvin.in_good_hands.feed.ui.utils.FeedScreenParams
import manuelklyukvin.in_good_hands.feed.ui.view_models.models.FeedState

@Composable
internal fun LoadingFeedScreen(state: FeedState) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppTheme.shapes.screenPadding)
            .clip(AppTheme.shapes.roundedCornerShape),
        columns = GridCells.Fixed(state.columnCount),
        verticalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.shapes.paddingSmall),
        userScrollEnabled = false
    ) {
        items(state.columnCount * 10) {
            LoadingFeedPostCard()
        }
    }
}

@Composable
private fun LoadingFeedPostCard() {
    AppCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(FeedScreenParams.POST_HEIGHT)
    ) {
        AppLoadingItem(
            modifier = Modifier
                .fillMaxWidth()
                .height(FeedScreenParams.IMAGE_HEIGHT)
        )
        Column(modifier = Modifier.padding(AppTheme.shapes.paddingSmall)) {
            AppLoadingItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppTheme.shapes.textTitleHeight)
            )
            Spacer(Modifier.height(AppTheme.shapes.paddingExtraSmall))
            AppLoadingItem()
            Spacer(Modifier.weight(1f))
            AppLoadingItem(height = AppTheme.shapes.textLabelHeight)
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
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colorScheme.background
        ) {
            LoadingFeedScreen(FeedState(columnCount = 2))
        }
    }
}