package manuelklyukvin.in_good_hands.build_src.modules

import manuelklyukvin.in_good_hands.build_src.utils.dataModule
import manuelklyukvin.in_good_hands.build_src.utils.diModule
import manuelklyukvin.in_good_hands.build_src.utils.domainModule
import manuelklyukvin.in_good_hands.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE = ":features:feed"

fun DependencyHandler.feedData() = dataModule(MODULE)
fun DependencyHandler.feedDomain() = domainModule(MODULE)
fun DependencyHandler.feedPresentation() = presentationModule(MODULE)
fun DependencyHandler.feedDi() = diModule(MODULE)