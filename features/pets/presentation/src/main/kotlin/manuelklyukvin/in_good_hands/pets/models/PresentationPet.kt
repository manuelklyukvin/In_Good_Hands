package manuelklyukvin.in_good_hands.pets.models

import androidx.annotation.StringRes

data class PresentationPet(
    val nickname: String?,
    @StringRes val typeResId: Int,
    @StringRes val genderResId: Int,
    val birthYear: Int?,
    val breed: String?
)