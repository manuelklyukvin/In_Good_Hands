package manuelklyukvin.in_good_hands.users.mappers

import manuelklyukvin.in_good_hands.users.models.DomainUser
import manuelklyukvin.in_good_hands.users.models.PresentationUser
import manuelklyukvin.in_good_hands.users.use_cases.GetAvatarUrlUseCase

class UserMapper(
    private val getAvatarUrlUseCase: GetAvatarUrlUseCase,
    private val userRoleMapper: UserRoleMapper
) {
    fun toPresentation(domainUser: DomainUser?) = domainUser?.let {
        with(domainUser) {
            PresentationUser(
                id = id,
                roleResId = userRoleMapper.toResId(roleId),
                avatarUrl = avatarName?.let { avatarName -> getAvatarUrlUseCase(avatarName) },
                email = email,
                phoneNumber = phoneNumber,
                name = name,
            )
        }
    }
}