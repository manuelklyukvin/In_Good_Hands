package manuelklyukvin.in_good_hands.menu.ui.view_models.models

import manuelklyukvin.in_good_hands.core.ui.navigation.NavigationState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIIntent

sealed class MenuIntent : MKUIIntent() {
    data object OnScreenOpened : MenuIntent()

    data class OnCurrentUserClicked(val navigationState: NavigationState) : MenuIntent()

    data class OnSignInButtonClicked(val navigationState: NavigationState) : MenuIntent()
    data class OnSignUpButtonClicked(val navigationState: NavigationState) : MenuIntent()
    data object OnSignOutButtonClicked : MenuIntent()

    data class OnPublishPostButtonClicked(val navigationState: NavigationState) : MenuIntent()

    data object OnRetryButtonClicked : MenuIntent()
}