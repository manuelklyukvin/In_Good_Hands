package manuelklyukvin.in_good_hands.post.mappers

import manuelklyukvin.in_good_hands.core.pets.mappers.PetAgeMapper
import manuelklyukvin.in_good_hands.core.pets.mappers.PetGenderMapper
import manuelklyukvin.in_good_hands.core.pets.mappers.PetTypeMapper
import manuelklyukvin.in_good_hands.core.posts.use_cases.GetPostImageUrlUseCase
import manuelklyukvin.in_good_hands.core.users.use_cases.GetAvatarUrlUseCase
import manuelklyukvin.in_good_hands.post.models.DomainPost
import manuelklyukvin.in_good_hands.post.models.PresentationPet
import manuelklyukvin.in_good_hands.post.models.PresentationPost
import manuelklyukvin.in_good_hands.post.models.PresentationUser
import manuelklyukvin.in_good_hands.post.use_cases.GetFormatedDateUseCase

class PostMapper(
    private val getPostImageUrlUseCase: GetPostImageUrlUseCase,
    private val getAvatarUrlUseCase: GetAvatarUrlUseCase,
    private val petTypeMapper: PetTypeMapper,
    private val petGenderMapper: PetGenderMapper,
    private val petAgeMapper: PetAgeMapper,
    private val getFormatedDateUseCase: GetFormatedDateUseCase
) {
    fun toPresentation(domainPost: DomainPost) = PresentationPost(
        id = domainPost.id,
        imageUrls = domainPost.imageNames.map { getPostImageUrlUseCase(it) },
        user = PresentationUser(
            id = domainPost.user.id,
            avatarUrl = domainPost.user.avatarName?.let { getAvatarUrlUseCase(it) },
            name = domainPost.user.name
        ),
        title = domainPost.title,
        description = domainPost.description,
        pet = PresentationPet(
            nickname = domainPost.pet.nickname,
            typeResId = petTypeMapper.toResId(domainPost.pet.typeId),
            genderResId = petGenderMapper.toResId(domainPost.pet.genderId),
            ageResId = petAgeMapper.toResId(domainPost.pet.ageId),
            breed = domainPost.pet.breed
        ),
        address = domainPost.address,
        publicationDate = getFormatedDateUseCase(domainPost.publicationDate)
    )
}