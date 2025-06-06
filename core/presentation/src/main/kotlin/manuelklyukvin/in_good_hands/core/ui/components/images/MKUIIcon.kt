package manuelklyukvin.in_good_hands.core.ui.components.images

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.R
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme

@Composable
fun MKUIIcon(
    modifier: Modifier = Modifier,
    model: Painter,
    tint: Color = MKUITheme.colorScheme.primary
) {
    Icon(
        modifier = modifier,
        painter = model,
        tint = tint,
        contentDescription = null
    )
}

@Preview
@Composable
private fun MKUIIconPreview() {
    MKUITheme {
        MKUIIcon(model = painterResource(R.drawable.avatar))
    }
}