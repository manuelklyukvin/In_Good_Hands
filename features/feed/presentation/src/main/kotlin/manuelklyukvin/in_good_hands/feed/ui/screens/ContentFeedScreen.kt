package manuelklyukvin.in_good_hands.feed.ui.screens

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import manuelklyukvin.in_good_hands.core.ui.components.MKUICard
import manuelklyukvin.in_good_hands.core.ui.components.buttons.MKUIButton
import manuelklyukvin.in_good_hands.core.ui.components.images.MKUIImage
import manuelklyukvin.in_good_hands.core.ui.components.texts.MKUILineText
import manuelklyukvin.in_good_hands.core.ui.components.texts.MKUIText
import manuelklyukvin.in_good_hands.core.ui.theme.LocalNavigationState
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme
import manuelklyukvin.in_good_hands.core.ui.utils.noIndicationClickable
import manuelklyukvin.in_good_hands.feed.R
import manuelklyukvin.in_good_hands.feed.models.PresentationFeedPost
import manuelklyukvin.in_good_hands.feed.ui.utils.FeedScreenParams
import manuelklyukvin.in_good_hands.feed.ui.view_models.models.FeedIntent
import manuelklyukvin.in_good_hands.feed.ui.view_models.models.FeedState

@Composable
internal fun ContentFeedScreen(state: FeedState, onIntent: (FeedIntent) -> Unit) {
    BackHandler(enabled = state.isPreviousPageButtonShown) {
        onIntent(FeedIntent.OnPreviousPageButtonClicked)
    }

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = MKUITheme.shapes.screenPadding)
            .clip(MKUITheme.shapes.roundedCornerShape),
        columns = GridCells.Fixed(state.columnCount),
        verticalArrangement = Arrangement.spacedBy(MKUITheme.shapes.paddingSmall),
        horizontalArrangement = Arrangement.spacedBy(MKUITheme.shapes.paddingSmall)
    ) {
        items(state.feedPosts) { feedPost ->
            FeedPostCard(feedPost, onIntent)
        }
        if (state.isPreviousPageButtonShown || state.isNextPageButtonShown) {
            item(span = { GridItemSpan(state.columnCount) }) {
                PageButtons(state, onIntent)
            }
        }
        when {
            state.feedPosts.isEmpty() -> item(span = { GridItemSpan(state.columnCount) }) {
                Warning(stringResource(R.string.no_feed_posts_found_warning))
            }
            !state.isNextPageButtonShown -> item(span = { GridItemSpan(state.columnCount) }) {
                Warning(stringResource(R.string.no_more_feed_posts_warning))
            }
        }
    }
}

@Composable
private fun FeedPostCard(feedPost: PresentationFeedPost, onIntent: (FeedIntent) -> Unit) {
    val navigationState = LocalNavigationState.current

    MKUICard(
        modifier = Modifier
            .height(FeedScreenParams.POST_HEIGHT)
            .noIndicationClickable {
                onIntent(FeedIntent.OnPostClicked(navigationState, feedPost.id))
            }
    ) {
        MKUIImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(175.dp)
                .clip(MKUITheme.shapes.roundedCornerShape),
            model = feedPost.imageUrl,
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(MKUITheme.shapes.paddingSmall)) {
            MKUIText(
                text = feedPost.title,
                style = MKUITheme.typography.title,
                color = MKUITheme.colorScheme.primary,
                maxLines = 2
            )
            MKUILineText(text = "${stringResource(R.string.pet_type_label)}: ${stringResource(feedPost.petTypeResId)}")
            Spacer(Modifier.weight(1f))
            MKUILineText(
                text = feedPost.city,
                style = MKUITheme.typography.label
            )
        }
    }
}

@Composable
private fun PageButtons(state: FeedState, onIntent: (FeedIntent) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(MKUITheme.shapes.paddingSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (state.isPreviousPageButtonShown) {
            MKUIButton(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.previous_page_button),
                onClick = { onIntent(FeedIntent.OnPreviousPageButtonClicked) }
            )
        }
        if (state.isNextPageButtonShown) {
            MKUIButton(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.next_page_button),
                onClick = { onIntent(FeedIntent.OnNextPageButtonClicked) }
            )
        }
    }
}

@Composable
private fun Warning(text: String) {
    MKUIText(
        text = text,
        color = MKUITheme.colorScheme.outline,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
private fun LightContentFeedScreenPreview() {
    ContentFeedScreenPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkContentFeedScreenPreview() {
    ContentFeedScreenPreview()
}

@Composable
private fun ContentFeedScreenPreview() {
    MKUITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MKUITheme.colorScheme.background
        ) {
            val feedPosts = List(3) {
                PresentationFeedPost(
                    id = 0,
                    imageUrl = "",
                    title = "Lost cat",
                    petTypeResId = R.string.pet_type_label,
                    city = "Belgrade"
                )
            }
            ContentFeedScreen(
                state = FeedState(columnCount = 2, feedPosts = feedPosts),
                onIntent = { }
            )
        }
    }
}