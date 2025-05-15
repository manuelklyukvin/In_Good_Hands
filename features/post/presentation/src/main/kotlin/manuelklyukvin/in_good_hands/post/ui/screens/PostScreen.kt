package manuelklyukvin.in_good_hands.post.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import manuelklyukvin.in_good_hands.core.ui.components.scaffolds.MKUITopBar
import manuelklyukvin.in_good_hands.core.ui.screens.MKUIErrorScreen
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIViewState
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MKUITheme.colorScheme.background)
    ) {
        MKUITopBar()
        when (state.viewState) {
            MKUIViewState.INITIAL -> Unit
            MKUIViewState.LOADING -> LoadingPostScreen()
            MKUIViewState.CONTENT -> ContentPostScreen(state, onIntent)
            MKUIViewState.ERROR -> MKUIErrorScreen(
                error = state.error,
                onRetryButtonClicked = { onIntent(PostIntent.OnRetryButtonClicked) }
            )
        }
    }
}