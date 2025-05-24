package manuelklyukvin.in_good_hands.build_src.modules.bundles

import manuelklyukvin.in_good_hands.build_src.modules.addressesPresentation
import manuelklyukvin.in_good_hands.build_src.modules.corePresentation
import manuelklyukvin.in_good_hands.build_src.modules.feedPresentation
import manuelklyukvin.in_good_hands.build_src.modules.menuPresentation
import manuelklyukvin.in_good_hands.build_src.modules.petsPresentation
import manuelklyukvin.in_good_hands.build_src.modules.postsPresentation
import manuelklyukvin.in_good_hands.build_src.modules.profilePresentation
import manuelklyukvin.in_good_hands.build_src.modules.usersPresentation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.presentationBundle() {
    corePresentation()

    usersPresentation()
    postsPresentation()
    petsPresentation()
    addressesPresentation()

    feedPresentation()
    menuPresentation()
    profilePresentation()
}