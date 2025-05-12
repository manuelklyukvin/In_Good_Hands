package manuelklyukvin.in_good_hands.core.posts.providers

interface PostImageUrlProvider {
    fun getPostImageUrl(imageName: String): String
}