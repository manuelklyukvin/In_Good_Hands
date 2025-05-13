package manuelklyukvin.in_good_hands.build_src.modules

import manuelklyukvin.in_good_hands.build_src.utils.dataModule
import manuelklyukvin.in_good_hands.build_src.utils.diModule
import manuelklyukvin.in_good_hands.build_src.utils.domainModule
import manuelklyukvin.in_good_hands.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE = ":core"

fun DependencyHandler.coreData() = dataModule(MODULE)
fun DependencyHandler.coreDomain() = domainModule(MODULE)
fun DependencyHandler.corePresentation() = presentationModule(MODULE)
fun DependencyHandler.coreDi() = diModule(MODULE)