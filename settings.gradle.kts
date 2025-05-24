rootProject.name = "In Good Hands"

val app = ":app"
val core = ":core"
val features = ":features"

val users = "$features:users"
val posts = "$features:posts"
val pets = "$features:pets"
val addresses = "$features:addresses"

val feed = "$features:feed"
val menu = "$features:menu"
val profile ="$features:profile"

include(app)
include(*modules(core))
include(features)

include(*modules(users))
include(*modules(posts))
include(*modules(pets))
include(*modules(addresses))

include(*modules(feed))
include(*modules(menu))
include(*modules(profile))

private fun modules(name: String) = arrayOf(
    name,
    "$name:data",
    "$name:domain",
    "$name:presentation",
    "$name:di"
)