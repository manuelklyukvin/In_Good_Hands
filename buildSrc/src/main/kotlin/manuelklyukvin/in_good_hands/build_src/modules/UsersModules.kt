package manuelklyukvin.in_good_hands.build_src.modules

import manuelklyukvin.in_good_hands.build_src.utils.dataModule
import manuelklyukvin.in_good_hands.build_src.utils.diModule
import manuelklyukvin.in_good_hands.build_src.utils.domainModule
import manuelklyukvin.in_good_hands.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE = ":features:users"

fun DependencyHandler.usersData() = dataModule(MODULE)
fun DependencyHandler.usersDomain() = domainModule(MODULE)
fun DependencyHandler.usersPresentation() = presentationModule(MODULE)
fun DependencyHandler.usersDi() = diModule(MODULE)