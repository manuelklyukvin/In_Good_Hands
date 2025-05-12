package manuelklyukvin.in_good_hands.core.utils.operations.providers

import manuelklyukvin.in_good_hands.core.utils.operations.models.OperationError

interface OperationErrorProvider {
    fun getOperationError(e: Exception): OperationError
}