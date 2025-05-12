package manuelklyukvin.in_good_hands.feed.ui.view_models

import androidx.compose.ui.unit.Dp
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import manuelklyukvin.in_good_hands.core.ui.navigation.NavigationState
import manuelklyukvin.in_good_hands.core.ui.navigation.Routes
import manuelklyukvin.in_good_hands.core.ui.view_models.CoreViewModel
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreViewState
import manuelklyukvin.in_good_hands.core.utils.operations.models.OperationResult
import manuelklyukvin.in_good_hands.core.utils.operations.use_cases.GetOperationErrorMessageUseCase
import manuelklyukvin.in_good_hands.feed.mappers.FeedPostMapper
import manuelklyukvin.in_good_hands.feed.ui.utils.FeedGridCalculator
import manuelklyukvin.in_good_hands.feed.ui.view_models.models.FeedIntent
import manuelklyukvin.in_good_hands.feed.ui.view_models.models.FeedState
import manuelklyukvin.in_good_hands.feed.use_cases.GetFeedPageUseCase

class FeedViewModel(
    private val getFeedPageUseCase: GetFeedPageUseCase,
    private val feedPostMapper: FeedPostMapper,
    private val getOperationErrorMessageUseCase: GetOperationErrorMessageUseCase,
    private val feedGridCalculator: FeedGridCalculator
) : CoreViewModel<FeedState, FeedIntent>(FeedState()) {
    private var loadFeedPageJob: Job? = null

    override fun onIntent(intent: FeedIntent) = when (intent) {
        is FeedIntent.OnScreenWidthUpdated -> onScreenWidthUpdated(intent.screenWidth, intent.spacing)
        FeedIntent.OnScreenOpened -> onScreenOpened()

        FeedIntent.OnSearchButtonClicked -> onSearchButtonClicked()

        is FeedIntent.OnPostClicked -> onPostClicked(intent.navigationState, intent.postId)
        FeedIntent.OnPreviousPageButtonClicked -> onPreviousPageButtonClicked()
        FeedIntent.OnNextPageButtonClicked -> onNextPageButtonClicked()

        FeedIntent.OnRetryButtonClicked -> onRetryButtonClicked()
    }

    private fun loadFeedPage() {
        reduce { copy(viewState = CoreViewState.LOADING) }
        loadFeedPageJob?.cancel()

        loadFeedPageJob = viewModelScope.launch {
            val getFeedPageResult = getFeedPageUseCase(
                currentPage = state.value.currentPage,
                searchQuery = state.value.searchQuery
            )
            when (getFeedPageResult) {
                is OperationResult.Success -> reduce {
                    copy(
                        viewState = CoreViewState.CONTENT,
                        feedPosts = getFeedPageResult.data.feedPosts.map {
                            feedPostMapper.toPresentation(it)
                        },
                        isPreviousPageButtonShown = state.value.currentPage > 0,
                        isNextPageButtonShown = getFeedPageResult.data.hasNextPage,
                        error = null
                    )
                }
                is OperationResult.Error -> reduce {
                    copy(
                        viewState = CoreViewState.ERROR,
                        error = getOperationErrorMessageUseCase(getFeedPageResult.error)
                    )
                }
            }
        }
    }

    private fun onScreenWidthUpdated(screenWidth: Dp, spacing: Dp) {
        val columnCount = feedGridCalculator.calculateColumns(screenWidth, spacing)
        if (state.value.columnCount != columnCount) reduce { copy(columnCount = columnCount) }
    }

    private fun onScreenOpened() = withInitialState { loadFeedPage() }

    private fun onSearchButtonClicked() = withContentState {
        val searchQuery = state.value.searchFieldState.text.toString().trim().takeIf {
            it.isNotBlank()
        }
        if (state.value.searchQuery != searchQuery) {
            reduce { copy(searchQuery = searchQuery, currentPage = 0) }
            loadFeedPage()
        }
    }

    private fun onPostClicked(navigationState: NavigationState, postId: Long) = withContentState {
        navigationState.navigateToRoute(Routes.Post(postId))
    }

    private fun onPreviousPageButtonClicked() = withContentState {
        if (state.value.isPreviousPageButtonShown && state.value.currentPage > 0) {
            reduce { copy(currentPage = currentPage - 1) }
            loadFeedPage()
        }
    }

    private fun onNextPageButtonClicked() = withContentState {
        if (state.value.isNextPageButtonShown) {
            reduce { copy(currentPage = currentPage + 1) }
            loadFeedPage()
        }
    }

    private fun onRetryButtonClicked() = withErrorState { loadFeedPage() }

    override fun onCleared() {
        super.onCleared()
        loadFeedPageJob?.cancel()
    }
}