package manuelklyukvin.in_good_hands.posts.repositories

import manuelklyukvin.in_good_hands.posts.models.DomainPost

interface PostRepository {
    suspend fun getPost(postId: Long, languageId: Int): DomainPost
}