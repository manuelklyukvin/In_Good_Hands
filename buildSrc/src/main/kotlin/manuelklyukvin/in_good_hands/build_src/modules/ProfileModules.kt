package manuelklyukvin.in_good_hands.build_src.modules

import manuelklyukvin.in_good_hands.build_src.utils.dataModule
import manuelklyukvin.in_good_hands.build_src.utils.diModule
import manuelklyukvin.in_good_hands.build_src.utils.domainModule
import manuelklyukvin.in_good_hands.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE = ":features:profile"

fun DependencyHandler.profileData() = dataModule(MODULE)
fun DependencyHandler.profileDomain() = domainModule(MODULE)
fun DependencyHandler.profilePresentation() = presentationModule(MODULE)
fun DependencyHandler.profileDi() = diModule(MODULE)