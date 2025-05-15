package manuelklyukvin.in_good_hands.core.ui.components.buttons

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import manuelklyukvin.in_good_hands.core.ui.components.MKUICard
import manuelklyukvin.in_good_hands.core.ui.components.texts.MKUILineText
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme
import manuelklyukvin.in_good_hands.core.ui.utils.noIndicationClickable

@Composable
fun MKUIButtons(
    modifier: Modifier = Modifier,
    vararg buttons: Pair<String, () -> Unit>
) {
    MKUICard(
        modifier = modifier.fillMaxWidth(),
        areDefaultPaddingsEnabled = true
    ) {
        buttons.forEachIndexed { index, button ->
            if (index > 0) {
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = MKUITheme.shapes.paddingMedium),
                    color = MKUITheme.colorScheme.outline,
                    thickness = 1.dp
                )
            }
            MKUILineText(
                modifier = Modifier
                    .fillMaxWidth()
                    .noIndicationClickable { button.second() },
                text = button.first
            )
        }
    }
}

@Preview
@Composable
private fun LightMKUIButtonsPreview() {
    MKUIButtonsPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkMKUIButtonsPreview() {
    MKUIButtonsPreview()
}

@Composable
private fun MKUIButtonsPreview() {
    MKUITheme {
        MKUIButtons(
            buttons = arrayOf(
                "First" to { },
                "Second" to { },
                "Third" to { }
            )
        )
    }
}