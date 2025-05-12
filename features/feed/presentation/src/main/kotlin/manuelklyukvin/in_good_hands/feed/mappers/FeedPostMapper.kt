package manuelklyukvin.in_good_hands.feed.mappers

import manuelklyukvin.in_good_hands.core.pets.mappers.PetTypeMapper
import manuelklyukvin.in_good_hands.core.posts.use_cases.GetPostImageUrlUseCase
import manuelklyukvin.in_good_hands.feed.models.DomainFeedPost
import manuelklyukvin.in_good_hands.feed.models.PresentationFeedPost

class FeedPostMapper(
    private val getPostImageUrlUseCase: GetPostImageUrlUseCase,
    private val petTypeMapper: PetTypeMapper
) {
    fun toPresentation(feedPost: DomainFeedPost) = PresentationFeedPost(
        id = feedPost.id,
        imageUrl = getPostImageUrlUseCase(feedPost.imageName),
        title = feedPost.title,
        petTypeResId = petTypeMapper.toResId(feedPost.petTypeId),
        city = feedPost.city
    )
}