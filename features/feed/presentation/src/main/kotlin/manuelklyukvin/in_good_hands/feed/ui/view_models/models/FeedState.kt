package manuelklyukvin.in_good_hands.feed.ui.view_models.models

import androidx.compose.foundation.text.input.TextFieldState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreViewState
import manuelklyukvin.in_good_hands.feed.models.PresentationFeedPost

data class FeedState(
    override val viewState: CoreViewState = CoreViewState.INITIAL,
    val columnCount: Int = 1,

    val searchFieldState: TextFieldState = TextFieldState(),
    val searchQuery: String? = null,

    val feedPosts: List<PresentationFeedPost> = emptyList(),
    val currentPage: Int = 0,
    val isPreviousPageButtonShown: Boolean = false,
    val isNextPageButtonShown: Boolean = false,

    val error: String? = null
) : CoreState()