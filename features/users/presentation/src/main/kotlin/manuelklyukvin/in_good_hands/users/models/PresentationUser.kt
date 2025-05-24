package manuelklyukvin.in_good_hands.users.models

import androidx.annotation.StringRes

data class PresentationUser(
    val id: Long,
    @StringRes val roleResId: Int,
    val avatarUrl: String?,
    val email: String,
    val phoneNumber: String,
    val name: String
)