package manuelklyukvin.in_good_hands.feed.repositories

import manuelklyukvin.in_good_hands.feed.models.DomainFeedPage

interface FeedPageRepository {
    suspend fun getFeedPage(
        postCount: Int,
        currentPage: Int,
        languageId: Int,
        searchQuery: String?
    ): DomainFeedPage
}