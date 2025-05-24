package manuelklyukvin.in_good_hands.users.use_cases

import manuelklyukvin.in_good_hands.users.providers.AvatarUrlProvider

class GetAvatarUrlUseCase(private val avatarUrlProvider: AvatarUrlProvider) {
    operator fun invoke(avatarName: String) = avatarUrlProvider.getAvatarUrl(avatarName)
}