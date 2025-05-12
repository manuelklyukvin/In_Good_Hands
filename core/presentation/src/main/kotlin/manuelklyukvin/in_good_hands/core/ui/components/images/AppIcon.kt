package manuelklyukvin.in_good_hands.core.ui.components.images

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import manuelklyukvin.in_good_hands.core.R
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme

@Composable
fun AppIcon(
    modifier: Modifier = Modifier,
    model: Painter,
    tint: Color = AppTheme.colorScheme.primary
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
private fun AppIconPreview() {
    AppTheme {
        AppIcon(model = painterResource(R.drawable.avatar))
    }
}