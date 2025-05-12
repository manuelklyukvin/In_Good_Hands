package manuelklyukvin.in_good_hands.post.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import manuelklyukvin.in_good_hands.core.ui.components.scaffolds.AppScaffold
import manuelklyukvin.in_good_hands.core.ui.screens.ErrorScreen
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreViewState
import manuelklyukvin.in_good_hands.post.ui.view_models.PostViewModel
import manuelklyukvin.in_good_hands.post.ui.view_models.models.PostIntent
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun PostScreen(
    postId: Long,
    viewModel: PostViewModel = koinViewModel(parameters = { parametersOf(postId) })
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val onIntent = viewModel::onIntent

    LaunchedEffect(postId) {
        onIntent(PostIntent.OnScreenOpened)
    }

    AppScaffold {
        when (state.viewState) {
            CoreViewState.INITIAL -> Unit
            CoreViewState.LOADING -> LoadingPostScreen()
            CoreViewState.CONTENT -> ContentPostScreen(state, onIntent)
            CoreViewState.ERROR -> ErrorScreen(
                error = state.error,
                onRetryButtonClicked = { onIntent(PostIntent.OnRetryButtonClicked) }
            )
        }
    }
}