package manuelklyukvin.in_good_hands.menu.ui.view_models

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import manuelklyukvin.in_good_hands.core.ui.navigation.NavigationState
import manuelklyukvin.in_good_hands.core.ui.view_models.MKUIViewModel
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIViewState
import manuelklyukvin.in_good_hands.core.utils.operations.models.OperationResult
import manuelklyukvin.in_good_hands.core.utils.operations.use_cases.GetOperationErrorMessageUseCase
import manuelklyukvin.in_good_hands.menu.mappers.UserMapper
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuIntent
import manuelklyukvin.in_good_hands.menu.ui.view_models.models.MenuState
import manuelklyukvin.in_good_hands.menu.use_cases.GetCurrentUserUseCase
import manuelklyukvin.in_good_hands.menu.use_cases.SignOutUserUseCase

class MenuViewModel(
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val userMapper: UserMapper,
    private val signOutUserUseCase: SignOutUserUseCase,
    private val getOperationErrorMessageUseCase: GetOperationErrorMessageUseCase
) : MKUIViewModel<MenuState, MenuIntent>(MenuState()) {
    private var loadCurrentUserJob: Job? = null
    private var signOutUserJob: Job? = null

    override fun onIntent(intent: MenuIntent) = when (intent) {
        MenuIntent.OnScreenOpened -> onScreenOpened()

        is MenuIntent.OnCurrentUserClicked -> onCurrentUserClicked(intent.navigationState)

        is MenuIntent.OnSignInButtonClicked -> onSignInButtonClicked(intent.navigationState)
        is MenuIntent.OnSignUpButtonClicked -> onSignUpButtonClicked(intent.navigationState)
        MenuIntent.OnSignOutButtonClicked -> onSignOutButtonClicked()

        is MenuIntent.OnPublishPostButtonClicked -> onPublishPostButtonClicked(intent.navigationState)

        MenuIntent.OnRetryButtonClicked -> onRetryButtonClicked()
    }

    private fun loadCurrentUser() {
        reduce { copy(viewState = MKUIViewState.LOADING) }
        loadCurrentUserJob?.cancel()

        loadCurrentUserJob = viewModelScope.launch {
            when (val getCurrentUserResult = getCurrentUserUseCase()) {
                is OperationResult.Success -> reduce {
                    copy(
                        viewState = MKUIViewState.CONTENT,
                        currentUser = getCurrentUserResult.data?.let {
                            userMapper.toPresentation(it)
                        },
                        error = null
                    )
                }
                is OperationResult.Error -> reduce {
                    copy(
                        viewState = MKUIViewState.ERROR,
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

    private fun onSignInButtonClicked(navigationState: NavigationState) = withContentState {
        if (state.value.currentUser == null) {

        }
    }

    private fun onSignUpButtonClicked(navigationState: NavigationState) = withContentState {
        if (state.value.currentUser == null) {

        }
    }

    private fun onSignOutButtonClicked() = withContentState {
        if (state.value.currentUser != null) {
            reduce { copy(viewState = MKUIViewState.LOADING) }
            signOutUserJob?.cancel()

            signOutUserJob = viewModelScope.launch {
                when (val signOutUserResult = signOutUserUseCase()) {
                    is OperationResult.Success -> reduce {
                        copy(
                            viewState = MKUIViewState.CONTENT,
                            currentUser = null,
                            error = null
                        )
                    }
                    is OperationResult.Error -> reduce {
                        copy(
                            viewState = MKUIViewState.ERROR,
                            error = getOperationErrorMessageUseCase(signOutUserResult.error)
                        )
                    }
                }
            }
        }
    }

    private fun onPublishPostButtonClicked(navigationState: NavigationState) = withContentState {
        if (state.value.currentUser != null) {

        }
    }

    private fun onRetryButtonClicked() = withErrorState { loadCurrentUser() }

    override fun onCleared() {
        loadCurrentUserJob?.cancel()
        signOutUserJob?.cancel()
    }
}