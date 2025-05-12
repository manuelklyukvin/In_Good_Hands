package manuelklyukvin.in_good_hands.core.pets.mappers

import manuelklyukvin.in_good_hands.core.R

class PetTypeMapper {
    fun toResId(petTypeId: Int) = when (petTypeId) {
        1 -> R.string.pet_type_cats
        2 -> R.string.pet_type_dogs
        3 -> R.string.pet_type_birds
        4 -> R.string.pet_type_fishes
        5 -> R.string.pet_type_rodents
        6 -> R.string.pet_type_reptiles
        7 -> R.string.pet_type_exotic
        else -> R.string.pet_type_other
    }
}