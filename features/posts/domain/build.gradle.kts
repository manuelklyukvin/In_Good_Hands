import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DomainGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.addressesDomain
import manuelklyukvin.in_good_hands.build_src.modules.petsDomain
import manuelklyukvin.in_good_hands.build_src.modules.usersDomain

apply<DomainGradlePlugin>()

dependencies {
    usersDomain()
    petsDomain()
    addressesDomain()
}