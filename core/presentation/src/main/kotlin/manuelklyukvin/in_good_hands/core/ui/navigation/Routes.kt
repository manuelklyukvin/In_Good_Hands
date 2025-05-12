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
    data object ProfileBlock : Routes()
    @Serializable
    data object Profile : Routes()
}