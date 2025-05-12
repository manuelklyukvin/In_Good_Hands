package manuelklyukvin.in_good_hands.post.repositories

import manuelklyukvin.in_good_hands.post.data_sources.PostDataSource
import manuelklyukvin.in_good_hands.post.models.toDomain

class PostRepositoryImpl(private val postDataSource: PostDataSource) : PostRepository {
    override suspend fun getPost(postId: Long, languageId: Int) = postDataSource.getPost(postId, languageId).toDomain()
}