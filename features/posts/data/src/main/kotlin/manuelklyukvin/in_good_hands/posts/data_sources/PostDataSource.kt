package manuelklyukvin.in_good_hands.posts.data_sources

import manuelklyukvin.in_good_hands.posts.models.DataPost
import retrofit2.http.GET
import retrofit2.http.Query

interface PostDataSource {
    @GET("posts")
    suspend fun getPost(
        @Query("post_id") postId: Long,
        @Query("language_id") languageId: Int
    ): DataPost
}