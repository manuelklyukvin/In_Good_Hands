package manuelklyukvin.in_good_hands.core.operations.use_cases

import manuelklyukvin.in_good_hands.core.operations.providers.OperationErrorProvider

class GetOperationErrorUseCase(private val operationErrorProvider: OperationErrorProvider) {
    operator fun invoke(e: Exception) = operationErrorProvider.getOperationError(e)
}