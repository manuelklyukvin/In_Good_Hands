import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DomainGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.usersDomain

apply<DomainGradlePlugin>()

dependencies {
    usersDomain()
}