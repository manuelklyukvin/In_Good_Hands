package manuelklyukvin.in_good_hands.pets.mappers

import manuelklyukvin.in_good_hands.pets.R

class PetGenderMapper {
    fun toResId(petGenderId: Int) = when (petGenderId) {
        1 -> R.string.pet_gender_male
        2 -> R.string.pet_gender_female
        else -> R.string.pet_gender_unknown
    }
}