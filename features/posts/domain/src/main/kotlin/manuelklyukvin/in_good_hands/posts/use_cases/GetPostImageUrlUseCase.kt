package manuelklyukvin.in_good_hands.posts.use_cases

import manuelklyukvin.in_good_hands.posts.providers.PostImageUrlProvider

class GetPostImageUrlUseCase(private val postImageUrlProvider: PostImageUrlProvider) {
    operator fun invoke(imageName: String) = postImageUrlProvider.getPostImageUrl(imageName)
}