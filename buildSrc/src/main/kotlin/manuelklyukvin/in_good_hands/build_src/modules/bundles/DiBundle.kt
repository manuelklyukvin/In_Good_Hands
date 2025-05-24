package manuelklyukvin.in_good_hands.build_src.modules.bundles

import manuelklyukvin.in_good_hands.build_src.modules.addressesDi
import manuelklyukvin.in_good_hands.build_src.modules.coreDi
import manuelklyukvin.in_good_hands.build_src.modules.feedDi
import manuelklyukvin.in_good_hands.build_src.modules.menuDi
import manuelklyukvin.in_good_hands.build_src.modules.petsDi
import manuelklyukvin.in_good_hands.build_src.modules.postsDi
import manuelklyukvin.in_good_hands.build_src.modules.profileDi
import manuelklyukvin.in_good_hands.build_src.modules.usersDi
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.diBundle() {
    coreDi()

    usersDi()
    postsDi()
    petsDi()
    addressesDi()

    feedDi()
    menuDi()
    profileDi()
}