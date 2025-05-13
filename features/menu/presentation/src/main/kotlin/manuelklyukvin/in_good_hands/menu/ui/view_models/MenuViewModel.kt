package manuelklyukvin.in_good_hands.menu.ui.view_models

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import manuelklyukvin.in_good_hands.core.ui.navigation.NavigationState
import manuelklyukvin.in_good_hands.core.ui.view_models.CoreViewModel
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreViewState
import manuelklyukvin.in_good_hands.core.utils.operations.models.OperationResult
import manuelklyukvin.in_good_hands.core.utils.operations.use_cases.GetOperationErrorMessageUseCase
import manuelklyukvin.in_good_hands.menu.mappers.UserMapper
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuIntent
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuState
import manuelklyukvin.in_good_hands.menu.use_cases.GetCurrentUserUseCase

class MenuViewModel(
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val userMapper: UserMapper,
    private val getOperationErrorMessageUseCase: GetOperationErrorMessageUseCase
) : CoreViewModel<MenuState, MenuIntent>(MenuState()) {
    private var loadCurrentUserJob: Job? = null

    override fun onIntent(intent: MenuIntent) = when (intent) {
        MenuIntent.OnScreenOpened -> onScreenOpened()
        is MenuIntent.OnCurrentUserClicked -> onCurrentUserClicked(intent.navigationState)
        MenuIntent.OnRetryButtonClicked -> onRetryButtonClicked()
    }

    private fun loadCurrentUser() {
        reduce { copy(viewState = CoreViewState.LOADING) }
        loadCurrentUserJob?.cancel()

        loadCurrentUserJob = viewModelScope.launch {
            when (val getCurrentUserResult = getCurrentUserUseCase()) {
                is OperationResult.Success -> reduce {
                    copy(
                        viewState = CoreViewState.CONTENT,
                        currentUser = getCurrentUserResult.data?.let {
                            userMapper.toPresentation(it)
                        },
                        error = null
                    )
                }
                is OperationResult.Error -> reduce {
                    copy(
                        viewState = CoreViewState.ERROR,
                        error = getOperationErrorMessageUseCase(getCurrentUserResult.error)
                    )
                }
            }
        }
    }

    private fun onScreenOpened() = withInitialState { loadCurrentUser() }

    private fun onCurrentUserClicked(navigationState: NavigationState) = withContentState {
        if (state.value.currentUser != null) {

        }
    }

    private fun onRetryButtonClicked() = withErrorState { loadCurrentUser() }

    override fun onCleared() { loadCurrentUserJob?.cancel() }
}