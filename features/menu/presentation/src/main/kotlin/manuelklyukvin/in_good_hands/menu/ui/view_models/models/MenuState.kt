package manuelklyukvin.in_good_hands.menu.ui.view_models.models

import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreViewState

data class MenuState(
    override val viewState: CoreViewState = CoreViewState.INITIAL,
    val error: String? = null
) : CoreState()