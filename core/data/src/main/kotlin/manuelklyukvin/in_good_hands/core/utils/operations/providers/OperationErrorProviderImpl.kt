package manuelklyukvin.in_good_hands.core.utils.operations.providers

import manuelklyukvin.in_good_hands.core.utils.operations.models.OperationError
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import kotlin.coroutines.cancellation.CancellationException

class OperationErrorProviderImpl : OperationErrorProvider {
    override fun getOperationError(e: Exception) = when (e) {
        is CancellationException -> throw e
        is ConnectException -> OperationError.Network
        is SocketTimeoutException -> OperationError.ServerUnavailable
        is HttpException -> {
            val errorCode = e.code()
            val errorBody = e.response()?.errorBody()?.string()
            when (errorCode) {
                400 -> OperationError.BadRequest(errorBody)
                404 -> OperationError.NotFound(errorBody)
                500 -> OperationError.Internal(errorBody)
                else -> OperationError.Server(errorCode, errorBody)
            }
        }
        else -> OperationError.Unknown(e.localizedMessage)
    }
}