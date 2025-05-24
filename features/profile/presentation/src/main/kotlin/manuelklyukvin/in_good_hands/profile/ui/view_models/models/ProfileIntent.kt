package manuelklyukvin.in_good_hands.profile.ui.view_models.models

import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIIntent

sealed class ProfileIntent : MKUIIntent() {
    data object OnScreenOpened : ProfileIntent()
    data object OnRetryButtonClicked : ProfileIntent()
}