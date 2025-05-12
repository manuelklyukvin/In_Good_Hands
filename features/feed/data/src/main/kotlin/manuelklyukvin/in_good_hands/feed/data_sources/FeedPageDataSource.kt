package manuelklyukvin.in_good_hands.feed.data_sources

import manuelklyukvin.in_good_hands.feed.models.DataFeedPage
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedPageDataSource {
    @GET("feed/page")
    suspend fun getFeedPage(
        @Query("post_count") postCount: Int,
        @Query("current_page") currentPage: Int,
        @Query("language_id") languageId: Int,
        @Query("search_query") searchQuery: String?
    ): DataFeedPage
}