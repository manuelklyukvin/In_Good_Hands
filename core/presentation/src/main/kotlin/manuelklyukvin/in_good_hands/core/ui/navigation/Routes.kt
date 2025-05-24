package manuelklyukvin.in_good_hands.core.ui.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    data object HomeBlock : Routes()
    @Serializable
    data object Feed : Routes()
    @Serializable
    data class Post(val postId: Long) : Routes()

    @Serializable
    data object MenuBlock : Routes()
    @Serializable
    data object Menu : Routes()
    @Serializable
    data class Profile(val userId: Long) : Routes()
}