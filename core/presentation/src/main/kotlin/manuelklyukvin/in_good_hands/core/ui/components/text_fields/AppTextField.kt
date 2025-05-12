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
import manuelklyukvin.in_good_hands.core.ui.components.AppCard
import manuelklyukvin.in_good_hands.core.ui.components.texts.AppLineText
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme

@Composable
fun AppTextField(
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
                    AppTheme.colorScheme.surface
                } else {
                    AppTheme.colorScheme.background
                },
                shape = AppTheme.shapes.roundedCornerShape
            )
            .let {
                if (error != null) {
                    it.border(
                        width = 1.dp,
                        color = AppTheme.colorScheme.error,
                        shape = AppTheme.shapes.roundedCornerShape
                    )
                } else it
            }
            .padding(AppTheme.shapes.paddingMedium),
        state = state,
        textStyle = AppTheme.typography.body.copy(
            color = if (isPrimary) {
                AppTheme.colorScheme.onSurface
            } else {
                AppTheme.colorScheme.onBackground
            }
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        lineLimits = TextFieldLineLimits.SingleLine,
        cursorBrush = SolidColor(AppTheme.colorScheme.primary),
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
        AppLineText(
            text = hint,
            color = AppTheme.colorScheme.outline
        )
    }
}

@Preview
@Composable
private fun PrimaryLightAppTextFieldPreview() {
    PrimaryAppTextFieldPreview()
}

@Preview
@Composable
private fun SecondaryLightAppTextFieldPreview() {
    SecondaryAppTextFieldPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PrimaryDarkAppTextFieldPreview() {
    PrimaryAppTextFieldPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SecondaryDarkAppTextFieldPreview() {
    SecondaryAppTextFieldPreview()
}

@Composable
private fun PrimaryAppTextFieldPreview() {
    AppTheme {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            AppTextField(state = TextFieldState("Preview"))
            AppTextField(
                state = TextFieldState("Preview"),
                label = "Label"
            )
            AppTextField(
                state = TextFieldState(),
                hint = "Hint"
            )
            AppTextField(
                state = TextFieldState(),
                error = "Error"
            )
        }
    }
}

@Composable
private fun SecondaryAppTextFieldPreview() {
    AppTheme {
        AppCard(
            areDefaultPaddingsEnabled = true,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AppTextField(
                isPrimary = false,
                state = TextFieldState("Preview")
            )
            AppTextField(
                isPrimary = false,
                state = TextFieldState("Preview"),
                label = "Label"
            )
            AppTextField(
                isPrimary = false,
                state = TextFieldState(),
                hint = "Hint"
            )
            AppTextField(
                isPrimary = false,
                state = TextFieldState(),
                error = "Error"
            )
        }
    }
}