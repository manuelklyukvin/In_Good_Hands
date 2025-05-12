package manuelklyukvin.in_good_hands.post.use_cases

import manuelklyukvin.in_good_hands.post.adapters.MapAdapter

class OpenMapUseCase(private val mapAdapter: MapAdapter) {
    operator fun invoke(address: String) = mapAdapter.openMap(address)
}