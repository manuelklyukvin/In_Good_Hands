package manuelklyukvin.in_good_hands.post.models

data class PresentationPost(
    val id: Long,
    val imageUrls: List<String>,
    val user: PresentationUser,
    val title: String,
    val description: String?,
    val pet: PresentationPet,
    val address: String,
    val publicationDate: String
)