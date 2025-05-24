package manuelklyukvin.in_good_hands.users.providers

interface AvatarUrlProvider {
    fun getAvatarUrl(avatarName: String): String
}