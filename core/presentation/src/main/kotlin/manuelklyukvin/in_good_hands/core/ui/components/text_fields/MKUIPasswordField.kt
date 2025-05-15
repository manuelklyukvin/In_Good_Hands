package manuelklyukvin.in_good_hands.core.ui.components.text_fields

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import manuelklyukvin.in_good_hands.core.R
import manuelklyukvin.in_good_hands.core.ui.components.MKUICard
import manuelklyukvin.in_good_hands.core.ui.components.images.MKUIIcon
import manuelklyukvin.in_good_hands.core.ui.components.texts.MKUILineText
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme

@Composable
fun MKUIPasswordField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    isPrimary: Boolean = true,
    label: String? = null,
    hint: String? = null,
    error: String? = null
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
                error = error
            )
        },
        error = error
    )
}

@Composable
private fun InnerTextField(
    state: TextFieldState,
    isPrimary: Boolean,
    hint: String?,
    error: String?
) {
    var isContentVisible by remember { mutableStateOf(false) }

    val textObfuscationMode: TextObfuscationMode
    val showPasswordButtonTint: Color

    if (isContentVisible) {
        textObfuscationMode = TextObfuscationMode.Visible
        showPasswordButtonTint = MKUITheme.colorScheme.primary
    } else {
        textObfuscationMode = TextObfuscationMode.RevealLastTyped
        showPasswordButtonTint = MKUITheme.colorScheme.onSurface
    }

    BasicSecureTextField(
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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textObfuscationMode = textObfuscationMode,
        cursorBrush = SolidColor(MKUITheme.colorScheme.primary),
        decorator = { inputField ->
            Decorator(
                state = state,
                inputField = inputField,
                hint = hint,
                showPasswordButtonTint = showPasswordButtonTint,
                onShowPasswordButtonClicked = { isContentVisible = !isContentVisible }
            )
        }
    )
}

@Composable
private fun Decorator(
    state: TextFieldState,
    inputField: @Composable () -> Unit,
    hint: String?,
    showPasswordButtonTint: Color,
    onShowPasswordButtonClicked: () -> Unit
) {
    Row {
        Box(modifier = Modifier.weight(1f)) {
            inputField()
            if (state.text.isEmpty() && hint != null) {
                MKUILineText(
                    text = hint,
                    color = MKUITheme.colorScheme.outline
                )
            }
        }
        Spacer(Modifier.width(MKUITheme.shapes.paddingMedium))
        IconButton(
            modifier = Modifier.size(MKUITheme.shapes.sizeExtraSmall),
            onClick = onShowPasswordButtonClicked
        ) {
            MKUIIcon(
                modifier = Modifier.fillMaxSize(),
                model = painterResource(R.drawable.eye),
                tint = showPasswordButtonTint
            )
        }
    }
}

@Preview
@Composable
private fun PrimaryLightMKUIPasswordFieldPreview() {
    PrimaryMKUIPasswordFieldPreview()
}

@Preview
@Composable
private fun SecondaryLightMKUIPasswordFieldPreview() {
    SecondaryMKUIPasswordFieldPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PrimaryDarkMKUIPasswordFieldPreview() {
    PrimaryMKUIPasswordFieldPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SecondaryDarkMKUIPasswordFieldPreview() {
    SecondaryMKUIPasswordFieldPreview()
}

@Composable
private fun PrimaryMKUIPasswordFieldPreview() {
    MKUITheme {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            MKUIPasswordField(state = TextFieldState("Preview"))
            MKUIPasswordField(
                state = TextFieldState("Preview"),
                label = "Label"
            )
            MKUIPasswordField(
                state = TextFieldState(),
                hint = "Hint"
            )
            MKUIPasswordField(
                state = TextFieldState(),
                error = "Error"
            )
        }
    }
}

@Composable
private fun SecondaryMKUIPasswordFieldPreview() {
    MKUITheme {
        MKUICard(
            areDefaultPaddingsEnabled = true,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            MKUIPasswordField(
                isPrimary = false,
                state = TextFieldState("Preview")
            )
            MKUIPasswordField(
                isPrimary = false,
                state = TextFieldState("Preview"),
                label = "Label"
            )
            MKUIPasswordField(
                isPrimary = false,
                state = TextFieldState(),
                hint = "Hint"
            )
            MKUIPasswordField(
                isPrimary = false,
                state = TextFieldState(),
                error = "Error"
            )
        }
    }
}