package manuelklyukvin.in_good_hands.users.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import manuelklyukvin.in_good_hands.core.operations.models.OperationResult
import manuelklyukvin.in_good_hands.core.operations.use_cases.GetOperationErrorUseCase
import manuelklyukvin.in_good_hands.users.repositories.UserRepository

class GetUserUseCase(
    private val userRepository: UserRepository,
    private val getOperationErrorUseCase: GetOperationErrorUseCase
) {
    suspend operator fun invoke(userId: Long) = try {
        val user = withContext(Dispatchers.IO) {
            userRepository.getUser(userId)
        }
        OperationResult.Success(user)
    } catch (e: Exception) {
        OperationResult.Error(getOperationErrorUseCase(e))
    }
}