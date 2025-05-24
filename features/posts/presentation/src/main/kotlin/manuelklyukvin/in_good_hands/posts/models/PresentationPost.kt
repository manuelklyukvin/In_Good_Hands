package manuelklyukvin.in_good_hands.posts.models

import manuelklyukvin.in_good_hands.pets.models.PresentationPet

data class PresentationPost(
    val id: Long,
    val imageUrls: List<String>,
    val postUser: PresentationPostUser,
    val title: String,
    val description: String?,
    val pet: PresentationPet,
    val addressLine: String,
    val publicationDate: String
)