package manuelklyukvin.in_good_hands.build_src.modules

import manuelklyukvin.in_good_hands.build_src.utils.dataModule
import manuelklyukvin.in_good_hands.build_src.utils.diModule
import manuelklyukvin.in_good_hands.build_src.utils.domainModule
import manuelklyukvin.in_good_hands.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE = ":features:pets"

fun DependencyHandler.petsData() = dataModule(MODULE)
fun DependencyHandler.petsDomain() = domainModule(MODULE)
fun DependencyHandler.petsPresentation() = presentationModule(MODULE)
fun DependencyHandler.petsDi() = diModule(MODULE)