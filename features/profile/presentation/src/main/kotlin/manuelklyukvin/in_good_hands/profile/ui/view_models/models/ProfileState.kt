package manuelklyukvin.in_good_hands.profile.ui.view_models.models

import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIViewState
import manuelklyukvin.in_good_hands.users.models.PresentationUser

data class ProfileState(
    override val viewState: MKUIViewState = MKUIViewState.INITIAL,
    val user: PresentationUser? = null,
    val error: String? = null
) : MKUIState()