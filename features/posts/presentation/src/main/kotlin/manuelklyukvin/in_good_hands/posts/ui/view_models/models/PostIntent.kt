package manuelklyukvin.in_good_hands.posts.ui.view_models.models

import manuelklyukvin.in_good_hands.core.ui.navigation.NavigationState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIIntent

sealed class PostIntent : MKUIIntent() {
    data object OnScreenOpened : PostIntent()
    data class OnUserClicked(val navigationState: NavigationState) : PostIntent()
    data object OnAddressClicked : PostIntent()
    data object OnRetryButtonClicked : PostIntent()
}