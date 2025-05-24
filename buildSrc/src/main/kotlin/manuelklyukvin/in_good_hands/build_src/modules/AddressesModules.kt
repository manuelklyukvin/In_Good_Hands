package manuelklyukvin.in_good_hands.build_src.modules

import manuelklyukvin.in_good_hands.build_src.utils.dataModule
import manuelklyukvin.in_good_hands.build_src.utils.diModule
import manuelklyukvin.in_good_hands.build_src.utils.domainModule
import manuelklyukvin.in_good_hands.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE = ":features:addresses"

fun DependencyHandler.addressesData() = dataModule(MODULE)
fun DependencyHandler.addressesDomain() = domainModule(MODULE)
fun DependencyHandler.addressesPresentation() = presentationModule(MODULE)
fun DependencyHandler.addressesDi() = diModule(MODULE)