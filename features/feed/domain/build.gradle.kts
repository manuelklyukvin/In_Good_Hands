import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DomainGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.addressesDomain
import manuelklyukvin.in_good_hands.build_src.modules.petsDomain
import manuelklyukvin.in_good_hands.build_src.modules.postsDomain

apply<DomainGradlePlugin>()

dependencies {
    postsDomain()
    petsDomain()
    addressesDomain()
}