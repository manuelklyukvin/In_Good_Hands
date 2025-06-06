package manuelklyukvin.in_good_hands.core.ui.components.text_fields

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import manuelklyukvin.in_good_hands.core.ui.components.texts.MKUIText
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme

@Composable
internal fun CoreTextField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    label: String? = null,
    innerTextField: @Composable () -> Unit,
    error: String? = null,
    maxLength: Int? = null
) {
    maxLength?.let {
        val valueLength = state.text.length

        LaunchedEffect(valueLength) {
            if (valueLength > maxLength) state.edit { delete(maxLength, valueLength) }
        }
    }

    Column(modifier = modifier) {
        label?.let {
            MKUIText(
                text = label,
                style = MKUITheme.typography.label,
                color = MKUITheme.colorScheme.outline
            )
        }
        innerTextField()
        error?.let {
            MKUIText(
                text = error,
                style = MKUITheme.typography.label,
                color = MKUITheme.colorScheme.error
            )
        }
    }
}