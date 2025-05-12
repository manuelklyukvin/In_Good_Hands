package manuelklyukvin.in_good_hands.core.utils.operations.use_cases

import manuelklyukvin.in_good_hands.core.utils.operations.models.OperationError
import manuelklyukvin.in_good_hands.core.utils.operations.providers.OperationErrorMessageProvider

class GetOperationErrorMessageUseCase(private val operationErrorMessageProvider: OperationErrorMessageProvider) {
    operator fun invoke(error: OperationError) = operationErrorMessageProvider.getOperationErrorMessage(error)
}