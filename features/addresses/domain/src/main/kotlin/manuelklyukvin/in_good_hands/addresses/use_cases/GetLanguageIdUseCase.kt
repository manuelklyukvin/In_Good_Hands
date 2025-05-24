package manuelklyukvin.in_good_hands.addresses.use_cases

import java.util.Locale

class GetLanguageIdUseCase {
    operator fun invoke() = when (Locale.getDefault().language) {
        "ru" -> 1
        "cs" -> 2
        else -> 0
    }
}