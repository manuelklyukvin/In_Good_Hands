package manuelklyukvin.in_good_hands.build_src.modules

import manuelklyukvin.in_good_hands.build_src.utils.dataModule
import manuelklyukvin.in_good_hands.build_src.utils.diModule
import manuelklyukvin.in_good_hands.build_src.utils.domainModule
import manuelklyukvin.in_good_hands.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE = ":features:posts"

fun DependencyHandler.postsData() = dataModule(MODULE)
fun DependencyHandler.postsDomain() = domainModule(MODULE)
fun DependencyHandler.postsPresentation() = presentationModule(MODULE)
fun DependencyHandler.postsDi() = diModule(MODULE)