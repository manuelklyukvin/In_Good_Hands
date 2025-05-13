package manuelklyukvin.in_good_hands.post.ui.view_models

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import manuelklyukvin.in_good_hands.core.ui.navigation.NavigationState
import manuelklyukvin.in_good_hands.core.ui.view_models.CoreViewModel
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreViewState
import manuelklyukvin.in_good_hands.core.utils.operations.models.OperationResult
import manuelklyukvin.in_good_hands.core.utils.operations.use_cases.GetOperationErrorMessageUseCase
import manuelklyukvin.in_good_hands.post.mappers.PostMapper
import manuelklyukvin.in_good_hands.post.ui.view_models.models.PostIntent
import manuelklyukvin.in_good_hands.post.ui.view_models.models.PostState
import manuelklyukvin.in_good_hands.post.use_cases.GetPostUseCase
import manuelklyukvin.in_good_hands.post.use_cases.OpenMapUseCase

class PostViewModel(
    private val postId: Long,
    private val getPostUseCase: GetPostUseCase,
    private val postMapper: PostMapper,
    private val getOperationErrorMessageUseCase: GetOperationErrorMessageUseCase,
    private val openMapUseCase: OpenMapUseCase,
) : CoreViewModel<PostState, PostIntent>(PostState()) {
    private var loadPostJob: Job? = null

    override fun onIntent(intent: PostIntent) = when (intent) {
        PostIntent.OnScreenOpened -> onScreenOpened()
        is PostIntent.OnUserClicked -> onUserClicked(intent.navigationState)
        PostIntent.OnAddressClicked -> onAddressClicked()
        PostIntent.OnRetryButtonClicked -> onRetryButtonClicked()
    }

    private fun loadPost() {
        reduce { copy(viewState = CoreViewState.LOADING) }
        loadPostJob?.cancel()

        loadPostJob = viewModelScope.launch {
            when (val getPostResult = getPostUseCase(postId)) {
                is OperationResult.Success -> reduce {
                    copy(
                        viewState = CoreViewState.CONTENT,
                        post = postMapper.toPresentation(getPostResult.data),
                        error = null
                    )
                }
                is OperationResult.Error -> reduce {
                    copy(
                        viewState = CoreViewState.ERROR,
                        error = getOperationErrorMessageUseCase(getPostResult.error)
                    )
                }
            }
        }
    }

    private fun onScreenOpened() = withInitialState { loadPost() }

    private fun onUserClicked(navigationState: NavigationState) = withContentState { }

    private fun onAddressClicked() = withContentState {
        state.value.post?.let { openMapUseCase(it.address) }
    }

    private fun onRetryButtonClicked() = withErrorState { loadPost() }

    override fun onCleared() { loadPostJob?.cancel() }
}