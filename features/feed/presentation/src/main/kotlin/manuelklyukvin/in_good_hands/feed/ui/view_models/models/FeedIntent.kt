package manuelklyukvin.in_good_hands.feed.ui.view_models.models

import androidx.compose.ui.unit.Dp
import manuelklyukvin.in_good_hands.core.ui.navigation.NavigationState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIIntent

sealed class FeedIntent : MKUIIntent() {
    data class OnScreenWidthUpdated(val screenWidth: Dp, val spacing: Dp) : FeedIntent()
    data object OnScreenOpened : FeedIntent()

    data object OnSearchButtonClicked : FeedIntent()

    data class OnPostClicked(val navigationState: NavigationState, val postId: Long) : FeedIntent()
    data object OnPreviousPageButtonClicked : FeedIntent()
    data object OnNextPageButtonClicked : FeedIntent()

    data object OnRetryButtonClicked : FeedIntent()
}