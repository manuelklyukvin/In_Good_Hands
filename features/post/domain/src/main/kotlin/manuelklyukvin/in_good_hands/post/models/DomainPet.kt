package manuelklyukvin.in_good_hands.post.models

data class DomainPet(
    val nickname: String?,
    val typeId: Int,
    val genderId: Int,
    val ageId: Int,
    val breed: String?
)