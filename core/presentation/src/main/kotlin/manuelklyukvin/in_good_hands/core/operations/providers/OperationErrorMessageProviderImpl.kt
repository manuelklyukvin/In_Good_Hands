package manuelklyukvin.in_good_hands.core.operations.providers

import android.content.Context
import manuelklyukvin.in_good_hands.core.R
import manuelklyukvin.in_good_hands.core.operations.models.OperationError

class OperationErrorMessageProviderImpl(private val context: Context) : OperationErrorMessageProvider {
    override fun getOperationErrorMessage(error: OperationError) = when (error) {
        OperationError.Network -> getString(R.string.operation_error_network)
        OperationError.ServerUnavailable -> getString(R.string.operation_error_server_unavailable)
        is OperationError.BadRequest -> formatErrorMessage(getString(R.string.operation_error_bad_request), error.message)
        is OperationError.NotFound -> formatErrorMessage(getString(R.string.operation_error_not_found), error.message)
        is OperationError.Internal -> formatErrorMessage(getString(R.string.operation_error_internal), error.message)
        is OperationError.Server -> formatErrorMessage("${getString(R.string.operation_error_server)} ${error.code}", error.message)
        is OperationError.Unknown -> formatErrorMessage(getString(R.string.operation_error_unknown), error.message)
    }

    private fun getString(resId: Int) = context.getString(resId)

    private fun formatErrorMessage(basePart: String, message: String?) = basePart + message?.let { ": $it" }
}