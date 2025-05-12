package manuelklyukvin.in_good_hands.post.models

import com.google.gson.annotations.SerializedName

data class DataPost(
    val id: Long,
    @SerializedName("image_names") val imageNames: List<String>,
    val user: DataUser,
    val title: String,
    val description: String?,
    val pet: DataPet,
    val address: String,
    @SerializedName("publication_date") val publicationDate: String
)

fun DataPost.toDomain() = DomainPost(
    id = id,
    imageNames = imageNames,
    user = user.toDomain(),
    title = title,
    description = description,
    pet = pet.toDomain(),
    address = address,
    publicationDate = publicationDate
)