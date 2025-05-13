package manuelklyukvin.in_good_hands.menu.ui.view_models

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import manuelklyukvin.in_good_hands.core.ui.view_models.CoreViewModel
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreViewState
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuIntent
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuState

class MenuViewModel : CoreViewModel<MenuState, MenuIntent>(MenuState()) {
    private var loadUserJob: Job? = null

    override fun onIntent(intent: MenuIntent) = when (intent) {
        MenuIntent.OnScreenOpened -> onScreenOpened()
        MenuIntent.OnRetryButtonClicked -> onRetryButtonClicked()
    }

    private fun loadUser() {
        reduce { copy(viewState = CoreViewState.LOADING) }
        loadUserJob?.cancel()

        loadUserJob = viewModelScope.launch {
            reduce { copy(viewState = CoreViewState.CONTENT) }
        }
    }

    private fun onScreenOpened() = withInitialState { loadUser() }

    private fun onRetryButtonClicked() = withErrorState { loadUser() }

    override fun onCleared() { loadUserJob?.cancel() }
}