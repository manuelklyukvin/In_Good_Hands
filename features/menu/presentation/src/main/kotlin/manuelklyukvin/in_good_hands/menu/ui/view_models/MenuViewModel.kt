package manuelklyukvin.in_good_hands.menu.ui.view_models

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import manuelklyukvin.in_good_hands.core.ui.view_models.CoreViewModel
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreViewState
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuIntent
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuState

class MenuViewModel : CoreViewModel<MenuState, MenuIntent>(MenuState()) {
    private var loadCurrentUserJob: Job? = null

    override fun onIntent(intent: MenuIntent) = when (intent) {
        MenuIntent.OnScreenOpened -> onScreenOpened()
        MenuIntent.OnRetryButtonClicked -> onRetryButtonClicked()
    }

    private fun loadCurrentUser() {
        reduce { copy(viewState = CoreViewState.LOADING) }
        loadCurrentUserJob?.cancel()

        loadCurrentUserJob = viewModelScope.launch {
            reduce { copy(viewState = CoreViewState.CONTENT) }
        }
    }

    private fun onScreenOpened() = withInitialState { loadCurrentUser() }

    private fun onRetryButtonClicked() = withErrorState { loadCurrentUser() }

    override fun onCleared() { loadCurrentUserJob?.cancel() }
}