package manuelklyukvin.in_good_hands.menu.ui.view_models.models

import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIViewState
import manuelklyukvin.in_good_hands.users.models.PresentationUser

data class MenuState(
    override val viewState: MKUIViewState = MKUIViewState.INITIAL,
    val currentUser: PresentationUser? = null,
    val error: String? = null
) : MKUIState()