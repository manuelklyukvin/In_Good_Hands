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
    dataModule(core),
    domainModule(core),
    presentationModule(core),
    diModule(core)
)
include(features)

include(
    feed,
    dataModule(feed),
    domainModule(feed),
    presentationModule(feed),
    diModule(feed)
)
include(
    post,
    dataModule(post),
    domainModule(post),
    presentationModule(post),
    diModule(post)
)

include(
    menu,
    dataModule(menu),
    domainModule(menu),
    presentationModule(menu),
    diModule(menu)
)

private fun dataModule(module: String) = "$module:data"
private fun domainModule(module: String) = "$module:domain"
private fun presentationModule(module: String) = "$module:presentation"
private fun diModule(module: String) = "$module:di"