package manuelklyukvin.in_good_hands.feed.models

import androidx.annotation.StringRes

data class PresentationFeedPost(
    val id: Long,
    val imageUrl: String,
    val title: String,
    @StringRes val petTypeResId: Int,
    val city: String
)