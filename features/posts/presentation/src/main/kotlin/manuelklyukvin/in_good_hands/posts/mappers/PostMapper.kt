package manuelklyukvin.in_good_hands.posts.mappers

import manuelklyukvin.in_good_hands.pets.mappers.PetMapper
import manuelklyukvin.in_good_hands.posts.models.DomainPost
import manuelklyukvin.in_good_hands.posts.models.PresentationPost
import manuelklyukvin.in_good_hands.posts.models.PresentationPostUser
import manuelklyukvin.in_good_hands.posts.use_cases.GetFormatedDateUseCase
import manuelklyukvin.in_good_hands.posts.use_cases.GetPostImageUrlUseCase
import manuelklyukvin.in_good_hands.users.use_cases.GetAvatarUrlUseCase

class PostMapper(
    private val getPostImageUrlUseCase: GetPostImageUrlUseCase,
    private val getAvatarUrlUseCase: GetAvatarUrlUseCase,
    private val petMapper: PetMapper,
    private val getFormatedDateUseCase: GetFormatedDateUseCase
) {
    fun toPresentation(domainPost: DomainPost) = with(domainPost) {
        PresentationPost(
            id = id,
            imageUrls = imageNames.map { getPostImageUrlUseCase(it) },
            postUser = PresentationPostUser(
                id = user.id,
                avatarUrl = user.avatarName?.let { getAvatarUrlUseCase(it) },
                name = user.name
            ),
            title = title,
            description = description,
            pet = petMapper.toPresentation(pet),
            addressLine = addressLine,
            publicationDate = getFormatedDateUseCase(publicationDate)
        )
    }
}