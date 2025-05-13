package manuelklyukvin.in_good_hands.menu.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import manuelklyukvin.in_good_hands.core.ui.components.scaffolds.AppScaffold
import manuelklyukvin.in_good_hands.core.ui.screens.ErrorScreen
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreViewState
import manuelklyukvin.in_good_hands.menu.ui.view_models.MenuViewModel
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuIntent
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(viewModel: MenuViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val onIntent = viewModel::onIntent

    LaunchedEffect(Unit) {
        onIntent(MenuIntent.OnScreenOpened)
    }

    AppScaffold {
        when (state.viewState) {
            CoreViewState.INITIAL -> Unit
            CoreViewState.LOADING -> LoadingMenuScreen()
            CoreViewState.CONTENT -> ContentMenuScreen(state, onIntent)
            CoreViewState.ERROR -> ErrorScreen(
                error = state.error,
                onRetryButtonClicked = { onIntent(MenuIntent.OnRetryButtonClicked) }
            )
        }
    }
}