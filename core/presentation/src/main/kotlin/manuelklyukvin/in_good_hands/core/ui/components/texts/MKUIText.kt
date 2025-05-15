package manuelklyukvin.in_good_hands.core.ui.components.texts

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme

@Composable
fun MKUIText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MKUITheme.typography.body,
    color: Color = style.color,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        style = style,
        color = color,
        maxLines = maxLines,
        textAlign = textAlign,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview
@Composable
private fun LightMKUITextPreview() {
    MKUITextPreview()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DarkMKUITextPreview() {
    MKUITextPreview()
}

@Composable
private fun MKUITextPreview() {
    MKUITheme {
        Surface(color = MKUITheme.colorScheme.surface) {
            MKUIText(text = "Preview")
        }
    }
}