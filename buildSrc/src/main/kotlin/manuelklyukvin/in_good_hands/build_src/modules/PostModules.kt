package manuelklyukvin.in_good_hands.build_src.modules

import manuelklyukvin.in_good_hands.build_src.utils.dataModule
import manuelklyukvin.in_good_hands.build_src.utils.diModule
import manuelklyukvin.in_good_hands.build_src.utils.domainModule
import manuelklyukvin.in_good_hands.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE = ":features:post"

fun DependencyHandler.postPresentation() = presentationModule(MODULE)
fun DependencyHandler.postDomain() = domainModule(MODULE)
fun DependencyHandler.postData() = dataModule(MODULE)
fun DependencyHandler.postDi() = diModule(MODULE)