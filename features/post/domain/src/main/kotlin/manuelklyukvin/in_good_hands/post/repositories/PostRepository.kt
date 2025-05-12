package manuelklyukvin.in_good_hands.post.repositories

import manuelklyukvin.in_good_hands.post.models.DomainPost

interface PostRepository {
    suspend fun getPost(postId: Long, languageId: Int): DomainPost
}