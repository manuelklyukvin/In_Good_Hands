package manuelklyukvin.in_good_hands.feed.models

import com.google.gson.annotations.SerializedName

data class DataFeedPost(
    val id: Long,
    @SerializedName("image_name") val imageName: String,
    val title: String,
    @SerializedName("pet_type_id") val petTypeId: Int,
    val city: String
)

fun DataFeedPost.toDomain() = DomainFeedPost(
    id = id,
    imageName = imageName,
    title = title,
    petTypeId = petTypeId,
    city = city
)