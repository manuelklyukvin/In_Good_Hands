package manuelklyukvin.in_good_hands.profile.ui.view_models

import kotlinx.coroutines.Job
import manuelklyukvin.in_good_hands.core.operations.use_cases.GetOperationErrorMessageUseCase
import manuelklyukvin.in_good_hands.core.ui.view_models.MKUIViewModel
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIViewState
import manuelklyukvin.in_good_hands.profile.ui.view_models.models.ProfileIntent
import manuelklyukvin.in_good_hands.profile.ui.view_models.models.ProfileState
import manuelklyukvin.in_good_hands.users.mappers.UserMapper
import manuelklyukvin.in_good_hands.users.use_cases.GetUserUseCase

class ProfileViewModel(
    private val userId: Long,
    private val getUserUseCase: GetUserUseCase,
    private val userMapper: UserMapper,
    private val getOperationErrorMessageUseCase: GetOperationErrorMessageUseCase
) : MKUIViewModel<ProfileState, ProfileIntent>(ProfileState()) {
    private var loadUserJob: Job? = null

    override fun onIntent(intent: ProfileIntent) = when (intent) {
        ProfileIntent.OnScreenOpened -> onScreenOpened()
        ProfileIntent.OnRetryButtonClicked -> onRetryButtonClicked()
    }

    private fun loadUser() {
        reduce { copy(viewState = MKUIViewState.LOADING) }
        loadUserJob?.cancel()

//        loadUserJob = viewModelScope.launch {
//            when (val getUserResult = getUserUseCase(userId)) {
//                is OperationResult.Success -> reduce {
//                    copy(
//                        viewState = MKUIViewState.CONTENT,
//                        user = userMapper.toPresentation(getUserResult.data),
//                        error = null
//                    )
//                }
//                is OperationResult.Error -> reduce {
//                    copy(
//                        viewState = MKUIViewState.ERROR,
//                        error = getOperationErrorMessageUseCase(getUserResult.error)
//                    )
//                }
//            }
//        }
        reduce { copy(viewState = MKUIViewState.CONTENT) }
    }

    private fun onScreenOpened() = withInitialState { loadUser() }

    private fun onRetryButtonClicked() = withInitialState { loadUser() }

    override fun onCleared() { loadUserJob?.cancel() }
}