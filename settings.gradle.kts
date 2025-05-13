rootProject.name = "In Good Hands"

val app = ":app"
val core = ":core"
val features = ":features"

val feed = "$features:feed"
val post = "$features:post"

val menu = "$features:menu"

include(app)
include(
    core,
    presentationModule(core),
    domainModule(core),
    dataModule(core),
    diModule(core)
)
include(features)

include(
    feed,
    presentationModule(feed),
    domainModule(feed),
    dataModule(feed),
    diModule(feed)
)
include(
    post,
    presentationModule(post),
    domainModule(post),
    dataModule(post),
    diModule(post)
)

include(
    menu,
    presentationModule(menu),
    diModule(menu)
)

private fun presentationModule(module: String) = "$module:presentation"
private fun domainModule(module: String) = "$module:domain"
private fun dataModule(module: String) = "$module:data"
private fun diModule(module: String) = "$module:di"