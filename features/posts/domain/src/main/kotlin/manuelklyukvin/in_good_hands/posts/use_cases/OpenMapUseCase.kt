package manuelklyukvin.in_good_hands.posts.use_cases

import manuelklyukvin.in_good_hands.posts.adapters.MapAdapter

class OpenMapUseCase(private val mapAdapter: MapAdapter) {
    operator fun invoke(address: String) = mapAdapter.openMap(address)
}