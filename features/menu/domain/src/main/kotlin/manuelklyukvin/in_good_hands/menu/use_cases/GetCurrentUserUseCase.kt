package manuelklyukvin.in_good_hands.menu.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import manuelklyukvin.in_good_hands.core.utils.operations.models.OperationResult
import manuelklyukvin.in_good_hands.core.utils.operations.use_cases.GetOperationErrorUseCase
import manuelklyukvin.in_good_hands.menu.repositories.UserRepository

class GetCurrentUserUseCase(
    private val userRepository: UserRepository,
    private val getOperationErrorUseCase: GetOperationErrorUseCase
) {
    suspend operator fun invoke() = try {
        val currentUser = withContext(Dispatchers.IO) {
            userRepository.getCurrentUser()
        }
        OperationResult.Success(currentUser)
    } catch (e: Exception) {
        OperationResult.Error(getOperationErrorUseCase(e))
    }
}