package manuelklyukvin.in_good_hands.build_src.modules.bundles

import manuelklyukvin.in_good_hands.build_src.modules.corePresentation
import manuelklyukvin.in_good_hands.build_src.modules.feedPresentation
import manuelklyukvin.in_good_hands.build_src.modules.menuPresentation
import manuelklyukvin.in_good_hands.build_src.modules.postPresentation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.presentationBundle() {
    corePresentation()

    feedPresentation()
    postPresentation()

    menuPresentation()
}