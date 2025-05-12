package manuelklyukvin.in_good_hands.post.models

data class DomainPost(
    val id: Long,
    val imageNames: List<String>,
    val user: DomainUser,
    val title: String,
    val description: String?,
    val pet: DomainPet,
    val address: String,
    val publicationDate: String
)