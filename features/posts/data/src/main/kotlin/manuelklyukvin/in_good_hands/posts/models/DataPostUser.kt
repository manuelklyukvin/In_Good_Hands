package manuelklyukvin.in_good_hands.posts.models

import com.google.gson.annotations.SerializedName

data class DataPostUser(
    val id: Long,
    @SerializedName("avatar_name") val avatarName: String?,
    val name: String
)

fun DataPostUser.toDomain() = DomainPostUser(
    id = id,
    avatarName = avatarName,
    name = name
)