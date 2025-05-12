package manuelklyukvin.in_good_hands.feed.models

data class DomainFeedPage(
    val feedPosts: List<DomainFeedPost>,
    val hasNextPage: Boolean
)