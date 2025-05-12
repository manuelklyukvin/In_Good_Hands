package manuelklyukvin.in_good_hands.feed.ui.utils

import androidx.compose.ui.unit.Dp

class FeedGridCalculator {
    fun calculateColumns(screenWidth: Dp, spacing: Dp): Int {
        val availableWidth = screenWidth - spacing * 2
        val postWidth = availableWidth / FeedScreenParams.POST_MIN_WIDTH
        return postWidth.toInt().coerceIn(1, FeedScreenParams.MAX_COLUMN_COUNT)
    }
}