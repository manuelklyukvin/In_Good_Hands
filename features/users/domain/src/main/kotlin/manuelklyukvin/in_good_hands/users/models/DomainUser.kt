package manuelklyukvin.in_good_hands.users.models

data class DomainUser(
    val id: Long,
    val roleId: Int,
    val avatarName: String?,
    val email: String,
    val phoneNumber: String,
    val name: String
)