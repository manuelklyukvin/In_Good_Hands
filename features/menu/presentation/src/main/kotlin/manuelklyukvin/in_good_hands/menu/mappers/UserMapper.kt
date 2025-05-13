package manuelklyukvin.in_good_hands.menu.mappers

import manuelklyukvin.in_good_hands.core.users.use_cases.GetAvatarUrlUseCase
import manuelklyukvin.in_good_hands.menu.models.DomainUser
import manuelklyukvin.in_good_hands.menu.models.PresentationUser

class UserMapper(private val getAvatarUrlUseCase: GetAvatarUrlUseCase) {
    fun toPresentation(domainUser: DomainUser) = with(domainUser) {
        PresentationUser(
            id = id,
            avatarUrl = avatarName?.let { getAvatarUrlUseCase(it) },
            name = name
        )
    }
}