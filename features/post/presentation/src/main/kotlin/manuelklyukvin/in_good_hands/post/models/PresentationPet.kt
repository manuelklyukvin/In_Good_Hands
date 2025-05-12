package manuelklyukvin.in_good_hands.post.models

import androidx.annotation.StringRes

data class PresentationPet(
    val nickname: String?,
    @StringRes val typeResId: Int,
    @StringRes val genderResId: Int,
    @StringRes val ageResId: Int,
    val breed: String?
)