package manuelklyukvin.in_good_hands.posts.providers

import manuelklyukvin.in_good_hands.core.api.Api

class PostImageUrlProviderImpl : PostImageUrlProvider {
    override fun getPostImageUrl(imageName: String) = "${Api.API_URL}/posts/images/$imageName"
}