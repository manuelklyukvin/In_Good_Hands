package manuelklyukvin.in_good_hands.core.operations.providers

import manuelklyukvin.in_good_hands.core.operations.models.OperationError

interface OperationErrorMessageProvider {
    fun getOperationErrorMessage(error: OperationError): String
}