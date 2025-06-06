package manuelklyukvin.in_good_hands.core.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import manuelklyukvin.in_good_hands.core.ui.theme.MKUITheme
import manuelklyukvin.in_good_hands.core.ui.utils.shimmerEffect

@Composable
fun MKUILoadingItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(MKUITheme.shapes.roundedCornerShape)
            .shimmerEffect()
    )
}