package manuelklyukvin.in_good_hands.core.utils.operations.use_cases

import manuelklyukvin.in_good_hands.core.utils.operations.providers.OperationErrorProvider

class GetOperationErrorUseCase(private val operationErrorProvider: OperationErrorProvider) {
    operator fun invoke(e: Exception) = operationErrorProvider.getOperationError(e)
}