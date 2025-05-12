package manuelklyukvin.in_good_hands.core.users.providers

import manuelklyukvin.in_good_hands.core.api.Api

class AvatarUrlProviderImpl : AvatarUrlProvider {
    override fun getAvatarUrl(avatarName: String) = "${Api.API_URL}/avatar/$avatarName"
}