package manuelklyukvin.in_good_hands.core.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.components.texts.MKUILineText
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme

@Composable
fun MKUICard(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    areDefaultPaddingsEnabled: Boolean = false,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .background(
                color = MKUITheme.colorScheme.surface,
                shape = MKUITheme.shapes.roundedCornerShape
            )
            .let {
                if (areDefaultPaddingsEnabled) {
                    it.padding(MKUITheme.shapes.paddingMedium)
                } else it
            },
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}

@Preview
@Composable
private fun LightMKUICardPreview() {
    MKUICardPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkMKUICardPreview() {
    MKUICardPreview()
}

@Composable
private fun MKUICardPreview() {
    MKUITheme {
        MKUICard(areDefaultPaddingsEnabled = true) {
            MKUILineText(text = "Preview")
        }
    }
}