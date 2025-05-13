package manuelklyukvin.in_good_hands.menu.ui.view_models.models

import manuelklyukvin.in_good_hands.core.ui.navigation.NavigationState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreIntent

sealed class MenuIntent : CoreIntent() {
    data object OnScreenOpened : MenuIntent()
    data class OnCurrentUserClicked(val navigationState: NavigationState) : MenuIntent()
    data object OnRetryButtonClicked : MenuIntent()
}