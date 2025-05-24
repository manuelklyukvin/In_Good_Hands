package manuelklyukvin.in_good_hands.posts.ui.view_models

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import manuelklyukvin.in_good_hands.core.operations.models.OperationResult
import manuelklyukvin.in_good_hands.core.operations.use_cases.GetOperationErrorMessageUseCase
import manuelklyukvin.in_good_hands.core.ui.navigation.NavigationState
import manuelklyukvin.in_good_hands.core.ui.view_models.MKUIViewModel
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIViewState
import manuelklyukvin.in_good_hands.posts.mappers.PostMapper
import manuelklyukvin.in_good_hands.posts.ui.view_models.models.PostIntent
import manuelklyukvin.in_good_hands.posts.ui.view_models.models.PostState
import manuelklyukvin.in_good_hands.posts.use_cases.GetPostUseCase
import manuelklyukvin.in_good_hands.posts.use_cases.OpenMapUseCase

class PostViewModel(
    private val postId: Long,
    private val getPostUseCase: GetPostUseCase,
    private val postMapper: PostMapper,
    private val getOperationErrorMessageUseCase: GetOperationErrorMessageUseCase,
    private val openMapUseCase: OpenMapUseCase,
) : MKUIViewModel<PostState, PostIntent>(PostState()) {
    private var loadPostJob: Job? = null

    override fun onIntent(intent: PostIntent) = when (intent) {
        PostIntent.OnScreenOpened -> onScreenOpened()
        is PostIntent.OnUserClicked -> onUserClicked(intent.navigationState)
        PostIntent.OnAddressClicked -> onAddressClicked()
        PostIntent.OnRetryButtonClicked -> onRetryButtonClicked()
    }

    private fun loadPost() {
        reduce { copy(viewState = MKUIViewState.LOADING) }
        loadPostJob?.cancel()

        loadPostJob = viewModelScope.launch {
            when (val getPostResult = getPostUseCase(postId)) {
                is OperationResult.Success -> reduce {
                    copy(
                        viewState = MKUIViewState.CONTENT,
                        post = postMapper.toPresentation(getPostResult.data),
                        error = null
                    )
                }
                is OperationResult.Error -> reduce {
                    copy(
                        viewState = MKUIViewState.ERROR,
                        error = getOperationErrorMessageUseCase(getPostResult.error)
                    )
                }
            }
        }
    }

    private fun onScreenOpened() = withInitialState { loadPost() }

    private fun onUserClicked(navigationState: NavigationState) = withContentState { }

    private fun onAddressClicked() = withContentState {
        state.value.post?.let { openMapUseCase(it.addressLine) }
    }

    private fun onRetryButtonClicked() = withErrorState { loadPost() }

    override fun onCleared() { loadPostJob?.cancel() }
}