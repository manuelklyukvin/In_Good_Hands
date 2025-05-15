package manuelklyukvin.in_good_hands.core.ui.components.images

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import manuelklyukvin.in_good_hands.core.R
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme

@Composable
fun MKUIImage(
    modifier: Modifier = Modifier,
    model: Any,
    contentScale: ContentScale = ContentScale.Fit
) {
    if (model is Painter) {
        Image(
            modifier = modifier,
            painter = model,
            contentScale = contentScale,
            contentDescription = null
        )
    } else {
        AsyncImage(
            modifier = modifier,
            model = model,
            contentScale = contentScale,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun MKUIImagePreview() {
    MKUITheme {
        MKUIImage(model = painterResource(R.drawable.avatar))
    }
}