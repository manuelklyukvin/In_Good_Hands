package manuelklyukvin.in_good_hands.post.models

import com.google.gson.annotations.SerializedName

data class DataUser(
    val id: Long,
    @SerializedName("avatar_name") val avatarName: String?,
    val name: String
)

fun DataUser.toDomain() = DomainUser(
    id = id,
    avatarName = avatarName,
    name = name
)