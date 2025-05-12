package manuelklyukvin.in_good_hands.feed.repositories

import manuelklyukvin.in_good_hands.feed.data_sources.FeedPageDataSource
import manuelklyukvin.in_good_hands.feed.models.toDomain

class FeedPageRepositoryImpl(private val feedPageDataSource: FeedPageDataSource) : FeedPageRepository {
    override suspend fun getFeedPage(
        postCount: Int,
        currentPage: Int,
        languageId: Int,
        searchQuery: String?
    ) = feedPageDataSource.getFeedPage(
        postCount = postCount,
        currentPage = currentPage,
        languageId = languageId,
        searchQuery = searchQuery
    ).toDomain()
}