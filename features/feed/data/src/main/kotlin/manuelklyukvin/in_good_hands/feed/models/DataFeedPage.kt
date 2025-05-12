package manuelklyukvin.in_good_hands.feed.models

import com.google.gson.annotations.SerializedName

data class DataFeedPage(
    @SerializedName("feed_posts") val feedPosts: List<DataFeedPost>,
    @SerializedName("has_next_page") val hasNextPage: Boolean
)

fun DataFeedPage.toDomain() = DomainFeedPage(
    feedPosts = feedPosts.map { it.toDomain() },
    hasNextPage = hasNextPage
)