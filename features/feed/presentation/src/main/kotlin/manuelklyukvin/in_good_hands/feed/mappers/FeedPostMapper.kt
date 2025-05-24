package manuelklyukvin.in_good_hands.feed.mappers

import manuelklyukvin.in_good_hands.feed.models.DomainFeedPost
import manuelklyukvin.in_good_hands.feed.models.PresentationFeedPost
import manuelklyukvin.in_good_hands.pets.mappers.PetTypeMapper
import manuelklyukvin.in_good_hands.posts.use_cases.GetPostImageUrlUseCase

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