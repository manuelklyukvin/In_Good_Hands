package manuelklyukvin.in_good_hands.posts.ui.view_models.models

import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIViewState
import manuelklyukvin.in_good_hands.posts.models.PresentationPost

data class PostState(
    override val viewState: MKUIViewState = MKUIViewState.INITIAL,
    val post: PresentationPost? = null,
    val error: String? = null
) : MKUIState()