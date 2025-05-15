package manuelklyukvin.in_good_hands.core.ui.components.buttons

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.components.texts.MKUIText
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme

@Composable
fun MKUIButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String? = null,
    isEnabled: Boolean = true,
    containerColor: Color = MKUITheme.colorScheme.primary,
    contentColor: Color = MKUITheme.colorScheme.onPrimary,
    content: @Composable (() -> Unit)? = null
) {
    val alpha = 0.5f
    val disabledContainerColor = containerColor.copy(alpha = alpha)
    val disabledContentColor = contentColor.copy(alpha = alpha)

    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = isEnabled,
        shape = MKUITheme.shapes.roundedCornerShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor
        ),
        contentPadding = PaddingValues(horizontal = MKUITheme.shapes.paddingExtraLarge)
    ) {
        if (text != null) {
            MKUIText(
                text = text,
                color = if (isEnabled) contentColor else disabledContentColor
            )
        } else if (content != null) content()
    }
}

@Preview
@Composable
private fun LightPrimaryMKUIButtonPreview() {
    PrimaryMKUIButtonPreview()
}

@Preview
@Composable
private fun LightSecondaryMKUIButtonPreview() {
    SecondaryMKUIButtonPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkPrimaryMKUIButtonPreview() {
    PrimaryMKUIButtonPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkSecondaryMKUIButtonPreview() {
    SecondaryMKUIButtonPreview()
}

@Composable
private fun PrimaryMKUIButtonPreview() {
    MKUITheme {
        Column {
            MKUIButton(
                text = "Enabled",
                onClick = { }
            )
            MKUIButton(
                text = "Disabled",
                onClick = { },
                isEnabled = false
            )
        }
    }
}

@Composable
private fun SecondaryMKUIButtonPreview() {
    MKUITheme {
        Column {
            MKUIButton(
                text = "Enabled",
                onClick = { },
                containerColor = MKUITheme.colorScheme.secondary,
                contentColor = MKUITheme.colorScheme.onSecondary
            )
            MKUIButton(
                text = "Disabled",
                onClick = { },
                isEnabled = false,
                containerColor = MKUITheme.colorScheme.secondary,
                contentColor = MKUITheme.colorScheme.onSecondary
            )
        }
    }
}