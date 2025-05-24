package manuelklyukvin.in_good_hands.posts.models

import com.google.gson.annotations.SerializedName
import manuelklyukvin.in_good_hands.pets.models.DataPet
import manuelklyukvin.in_good_hands.pets.models.toDomain

data class DataPost(
    val id: Long,
    @SerializedName("image_names") val imageNames: List<String>,
    @SerializedName("post_user") val postUser: DataPostUser,
    val title: String,
    val description: String?,
    val pet: DataPet,
    @SerializedName("address_line") val addressLine: String,
    @SerializedName("publication_date") val publicationDate: String
)

fun DataPost.toDomain() = DomainPost(
    id = id,
    imageNames = imageNames,
    user = postUser.toDomain(),
    title = title,
    description = description,
    pet = pet.toDomain(),
    addressLine = addressLine,
    publicationDate = publicationDate
)