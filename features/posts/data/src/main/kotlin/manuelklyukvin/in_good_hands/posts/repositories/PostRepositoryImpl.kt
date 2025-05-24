package manuelklyukvin.in_good_hands.posts.repositories

import manuelklyukvin.in_good_hands.posts.data_sources.PostDataSource
import manuelklyukvin.in_good_hands.posts.models.toDomain

class PostRepositoryImpl(private val postDataSource: PostDataSource) : PostRepository {
    override suspend fun getPost(postId: Long, languageId: Int) = postDataSource.getPost(postId, languageId).toDomain()
}