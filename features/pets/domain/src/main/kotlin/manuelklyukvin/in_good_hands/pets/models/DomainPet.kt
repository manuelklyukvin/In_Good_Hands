package manuelklyukvin.in_good_hands.pets.models

data class DomainPet(
    val nickname: String?,
    val typeId: Int,
    val genderId: Int,
    val birthYear: Int?,
    val breed: String?
)