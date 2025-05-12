package manuelklyukvin.in_good_hands.feed.models

data class DomainFeedPost(
    val id: Long,
    val imageName: String,
    val title: String,
    val petTypeId: Int,
    val city: String
)