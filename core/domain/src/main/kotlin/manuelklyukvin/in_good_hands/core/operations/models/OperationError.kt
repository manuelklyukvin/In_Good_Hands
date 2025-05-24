package manuelklyukvin.in_good_hands.core.operations.models

sealed class OperationError {
    data object Network : OperationError()
    data object ServerUnavailable : OperationError()
    data class BadRequest(val message: String?) : OperationError()
    data class NotFound(val message: String?) : OperationError()
    data class Internal(val message: String?) : OperationError()
    data class Server(val code: Int, val message: String?) : OperationError()
    data class Unknown(val message: String?) : OperationError()
}