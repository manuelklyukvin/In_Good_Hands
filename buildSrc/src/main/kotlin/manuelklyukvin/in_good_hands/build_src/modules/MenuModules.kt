package manuelklyukvin.in_good_hands.build_src.modules

import manuelklyukvin.in_good_hands.build_src.utils.diModule
import manuelklyukvin.in_good_hands.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE = ":features:menu"

fun DependencyHandler.menuPresentation() = presentationModule(MODULE)
fun DependencyHandler.menuDi() = diModule(MODULE)