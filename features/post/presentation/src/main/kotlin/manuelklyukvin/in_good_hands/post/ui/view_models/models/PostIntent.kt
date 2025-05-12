package manuelklyukvin.in_good_hands.post.ui.view_models.models

import manuelklyukvin.in_good_hands.core.ui.navigation.NavigationState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreIntent

sealed class PostIntent : CoreIntent() {
    data object OnScreenOpened : PostIntent()
    data class OnUserClicked(val navigationState: NavigationState) : PostIntent()
    data object OnAddressClicked : PostIntent()
    data object OnRetryButtonClicked : PostIntent()
}