package manuelklyukvin.in_good_hands.post.ui.view_models.models

import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.CoreViewState
import manuelklyukvin.in_good_hands.post.models.PresentationPost

data class PostState(
    override val viewState: CoreViewState = CoreViewState.INITIAL,
    val post: PresentationPost? = null,
    val error: String? = null
) : CoreState()