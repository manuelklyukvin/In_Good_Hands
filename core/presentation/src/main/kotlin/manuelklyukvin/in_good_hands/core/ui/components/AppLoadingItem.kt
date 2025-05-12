package manuelklyukvin.in_good_hands.core.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import manuelklyukvin.in_good_hands.core.ui.theme.AppTheme
import manuelklyukvin.in_good_hands.core.ui.utils.shimmerEffect

@Composable
fun AppLoadingItem(
    modifier: Modifier? = null,
    width: Dp = AppTheme.shapes.textWidthSmall,
    height: Dp = AppTheme.shapes.textBodyHeight
) {
    Box(
        modifier = (modifier ?: Modifier.size(width = width, height = height))
            .clip(AppTheme.shapes.roundedCornerShape)
            .shimmerEffect()
    )
}