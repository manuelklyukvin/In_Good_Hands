package manuelklyukvin.in_good_hands.users.models

import com.google.gson.annotations.SerializedName

data class DataUser(
    val id: Long,
    @SerializedName("role_id") val roleId: Int,
    @SerializedName("avatar_name") val avatarName: String?,
    val email: String,
    @SerializedName("phone_number") val phoneNumber: String,
    val name: String
)

fun DataUser.toDomain() = DomainUser(
    id = id,
    roleId = roleId,
    avatarName = avatarName,
    email = email,
    phoneNumber = phoneNumber,
    name = name
)