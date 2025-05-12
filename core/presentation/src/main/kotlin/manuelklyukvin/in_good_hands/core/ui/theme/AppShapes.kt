package manuelklyukvin.in_good_hands.core.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp

data class AppShapes(
    val screenPadding: Dp,
    val roundedCornerShape: RoundedCornerShape,

    val paddingExtraSmall: Dp,
    val paddingSmall: Dp,
    val paddingMedium: Dp,
    val paddingLarge: Dp,
    val paddingExtraLarge: Dp,

    val sizeExtraSmall: Dp,
    val sizeSmall: Dp,
    val sizeMedium: Dp,
    val sizeLarge: Dp,
    val sizeExtraLarge: Dp,

    val textLabelHeight: Dp,
    val textBodyHeight: Dp,
    val textTitleHeight: Dp,
    val textHeadlineHeight: Dp,
    val textWidthSmall: Dp,
    val textWidthMedium: Dp,
    val textWidthLarge: Dp
)