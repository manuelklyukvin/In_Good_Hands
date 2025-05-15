package manuelklyukvin.in_good_hands.core.ui.components.text_fields

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import manuelklyukvin.in_good_hands.core.ui.components.MKUICard
import manuelklyukvin.in_good_hands.core.ui.components.texts.MKUILineText
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme

@Composable
fun MKUITextField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    isPrimary: Boolean = true,
    label: String? = null,
    hint: String? = null,
    error: String? = null,
    maxLength: Int? = null,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    CoreTextField(
        modifier = modifier,
        state = state,
        label = label,
        innerTextField = {
            InnerTextField(
                state = state,
                isPrimary = isPrimary,
                hint = hint,
                error = error,
                keyboardType = keyboardType
            )
        },
        error = error,
        maxLength = maxLength
    )
}

@Composable
private fun InnerTextField(
    state: TextFieldState,
    isPrimary: Boolean,
    hint: String?,
    error: String?,
    keyboardType: KeyboardType
) {
    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (isPrimary) {
                    MKUITheme.colorScheme.surface
                } else {
                    MKUITheme.colorScheme.background
                },
                shape = MKUITheme.shapes.roundedCornerShape
            )
            .let {
                if (error != null) {
                    it.border(
                        width = 1.dp,
                        color = MKUITheme.colorScheme.error,
                        shape = MKUITheme.shapes.roundedCornerShape
                    )
                } else it
            }
            .padding(MKUITheme.shapes.paddingMedium),
        state = state,
        textStyle = MKUITheme.typography.body.copy(
            color = if (isPrimary) {
                MKUITheme.colorScheme.onSurface
            } else {
                MKUITheme.colorScheme.onBackground
            }
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        lineLimits = TextFieldLineLimits.SingleLine,
        cursorBrush = SolidColor(MKUITheme.colorScheme.primary),
        decorator = { inputField ->
            Decorator(
                state = state,
                inputField = inputField,
                hint = hint
            )
        }
    )
}


@Composable
private fun Decorator(
    state: TextFieldState,
    inputField: @Composable () -> Unit,
    hint: String?
) {
    inputField()
    if (state.text.isEmpty() && hint != null) {
        MKUILineText(
            text = hint,
            color = MKUITheme.colorScheme.outline
        )
    }
}

@Preview
@Composable
private fun PrimaryLightMKUITextFieldPreview() {
    PrimaryMKUITextFieldPreview()
}

@Preview
@Composable
private fun SecondaryLightMKUITextFieldPreview() {
    SecondaryMKUITextFieldPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PrimaryDarkMKUITextFieldPreview() {
    PrimaryMKUITextFieldPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SecondaryDarkMKUITextFieldPreview() {
    SecondaryMKUITextFieldPreview()
}

@Composable
private fun PrimaryMKUITextFieldPreview() {
    MKUITheme {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            MKUITextField(state = TextFieldState("Preview"))
            MKUITextField(
                state = TextFieldState("Preview"),
                label = "Label"
            )
            MKUITextField(
                state = TextFieldState(),
                hint = "Hint"
            )
            MKUITextField(
                state = TextFieldState(),
                error = "Error"
            )
        }
    }
}

@Composable
private fun SecondaryMKUITextFieldPreview() {
    MKUITheme {
        MKUICard(
            areDefaultPaddingsEnabled = true,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            MKUITextField(
                isPrimary = false,
                state = TextFieldState("Preview")
            )
            MKUITextField(
                isPrimary = false,
                state = TextFieldState("Preview"),
                label = "Label"
            )
            MKUITextField(
                isPrimary = false,
                state = TextFieldState(),
                hint = "Hint"
            )
            MKUITextField(
                isPrimary = false,
                state = TextFieldState(),
                error = "Error"
            )
        }
    }
}