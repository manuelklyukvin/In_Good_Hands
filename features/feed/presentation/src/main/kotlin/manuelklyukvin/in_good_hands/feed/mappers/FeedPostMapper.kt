package manuelklyukvin.in_good_hands.feed.mappers

import manuelklyukvin.in_good_hands.core.pets.mappers.PetTypeMapper
import manuelklyukvin.in_good_hands.core.posts.use_cases.GetPostImageUrlUseCase
import manuelklyukvin.in_good_hands.feed.models.DomainFeedPost
import manuelklyukvin.in_good_hands.feed.models.PresentationFeedPost

class FeedPostMapper(
    private val getPostImageUrlUseCase: GetPostImageUrlUseCase,
    private val petTypeMapper: PetTypeMapper
) {
    fun toPresentation(domainFeedPost: DomainFeedPost) = with(domainFeedPost) {
        PresentationFeedPost(
            id = id,
            imageUrl = getPostImageUrlUseCase(imageName),
            title = title,
            petTypeResId = petTypeMapper.toResId(petTypeId),
            city = city
        )
    }
}