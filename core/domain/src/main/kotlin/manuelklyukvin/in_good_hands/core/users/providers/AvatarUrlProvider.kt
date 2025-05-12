package manuelklyukvin.in_good_hands.core.users.providers

interface AvatarUrlProvider {
    fun getAvatarUrl(avatarName: String): String
}