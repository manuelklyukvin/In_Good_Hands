package manuelklyukvin.in_good_hands.core.ui.view_models

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIIntent
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIState
import manuelklyukvin.in_good_hands.core.ui.view_models.models.MKUIViewState

abstract class MKUIViewModel<S : MKUIState, I : MKUIIntent>(initialState: S) : ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state get() = _state.asStateFlow()

    protected fun reduce(reducer: S.() -> S) = _state.update { it.reducer() }

    abstract fun onIntent(intent: I)

    protected inline fun withInitialState(block: () -> Unit) {
        if (state.value.viewState == MKUIViewState.INITIAL) block()
    }
    protected inline fun withLoadingState(block: () -> Unit) {
        if (state.value.viewState == MKUIViewState.LOADING) block()
    }
    protected inline fun withContentState(block: () -> Unit) {
        if (state.value.viewState == MKUIViewState.CONTENT) block()
    }
    protected inline fun withErrorState(block: () -> Unit) {
        if (state.value.viewState == MKUIViewState.ERROR) block()
    }
}