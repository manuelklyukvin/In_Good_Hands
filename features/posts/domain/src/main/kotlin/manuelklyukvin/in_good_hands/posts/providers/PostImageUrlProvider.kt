package manuelklyukvin.in_good_hands.posts.providers

interface PostImageUrlProvider {
    fun getPostImageUrl(imageName: String): String
}