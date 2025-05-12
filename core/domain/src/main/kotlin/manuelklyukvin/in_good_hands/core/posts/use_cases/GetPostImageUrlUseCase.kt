package manuelklyukvin.in_good_hands.core.posts.use_cases

import manuelklyukvin.in_good_hands.core.posts.providers.PostImageUrlProvider

class GetPostImageUrlUseCase(private val postImageUrlProvider: PostImageUrlProvider) {
    operator fun invoke(imageName: String) = postImageUrlProvider.getPostImageUrl(imageName)
}