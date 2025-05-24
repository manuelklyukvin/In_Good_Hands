package manuelklyukvin.in_good_hands.posts.models

import manuelklyukvin.in_good_hands.pets.models.DomainPet

data class DomainPost(
    val id: Long,
    val imageNames: List<String>,
    val user: DomainPostUser,
    val title: String,
    val description: String?,
    val pet: DomainPet,
    val addressLine: String,
    val publicationDate: String
)