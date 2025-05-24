package manuelklyukvin.in_good_hands.core.operations.use_cases

import manuelklyukvin.in_good_hands.core.operations.models.OperationError
import manuelklyukvin.in_good_hands.core.operations.providers.OperationErrorMessageProvider

class GetOperationErrorMessageUseCase(private val operationErrorMessageProvider: OperationErrorMessageProvider) {
    operator fun invoke(error: OperationError) = operationErrorMessageProvider.getOperationErrorMessage(error)
}