package manuelklyukvin.in_good_hands.core.pets.mappers

import manuelklyukvin.in_good_hands.core.R

class PetAgeMapper {
    fun toResId(petAgeId: Int) = when (petAgeId) {
        1 -> R.string.pet_age_under_1
        2 -> R.string.pet_age_from_1_to_3
        3 -> R.string.pet_age_from_4_to_6
        4 -> R.string.pet_age_from_7_to_10
        5 -> R.string.pet_age_from_11_to_15
        6 -> R.string.pet_age_over_15
        else -> R.string.pet_age_unknown
    }
}