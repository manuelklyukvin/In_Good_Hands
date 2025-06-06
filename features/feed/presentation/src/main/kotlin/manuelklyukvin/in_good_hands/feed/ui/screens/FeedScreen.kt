package manuelklyukvin.in_good_hands.feed.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import manuelklyukvin.in_good_hands.core.ui.components.images.MKUIIcon
import manuelklyukvin.in_good_hands.core.ui.components.text_fields.MKUITextField
import manuelklyukvin.in_good_hands.core.ui.screens.MKUIErrorScreen
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme
import manuelklyukvin.in_good_hands.core.ui.utils.noIndicationClickable
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIViewState
import manuelklyukvin.in_good_hands.feed.R
import manuelklyukvin.in_good_hands.feed.ui.view_models.FeedViewModel
import manuelklyukvin.in_good_hands.feed.ui.view_models.models.FeedIntent
import manuelklyukvin.in_good_hands.feed.ui.view_models.models.FeedState
import org.koin.androidx.compose.koinViewModel
import manuelklyukvin.in_good_hands.core.R as CoreR

@SuppressLint("NewApi", "ConfigurationScreenWidthHeight")
@Composable
fun FeedScreen(viewModel: FeedViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val onIntent = viewModel::onIntent

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val spacing = MKUITheme.shapes.screenPadding

    LaunchedEffect(screenWidth) {
        onIntent(FeedIntent.OnScreenWidthUpdated(screenWidth, spacing))
    }
    LaunchedEffect(Unit) {
        onIntent(FeedIntent.OnScreenOpened)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MKUITheme.colorScheme.background)
    ) {
        SearchBar(state, onIntent)
        when (state.viewState) {
            MKUIViewState.INITIAL -> Unit
            MKUIViewState.LOADING -> LoadingFeedScreen(state)
            MKUIViewState.CONTENT -> ContentFeedScreen(state, onIntent)
            MKUIViewState.ERROR -> MKUIErrorScreen(
                error = state.error,
                onRetryButtonClicked = { onIntent(FeedIntent.OnRetryButtonClicked) }
            )
        }
    }
}

@Composable
private fun SearchBar(state: FeedState, onIntent: (FeedIntent) -> Unit) {
    Row(
        modifier = Modifier.padding(
            vertical = MKUITheme.shapes.paddingSmall,
            horizontal = MKUITheme.shapes.screenPadding
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MKUITextField(
            modifier = Modifier.weight(1f),
            state = state.searchFieldState,
            hint = stringResource(R.string.search_query_hint)
        )
        Spacer(Modifier.width(MKUITheme.shapes.paddingSmall))
        MKUIIcon(
            modifier = Modifier
                .size(MKUITheme.shapes.sizeMedium)
                .noIndicationClickable { onIntent(FeedIntent.OnSearchButtonClicked) },
            model = painterResource(CoreR.drawable.search)
        )
    }
}