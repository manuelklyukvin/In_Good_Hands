import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.PresentationGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.addressesDomain
import manuelklyukvin.in_good_hands.build_src.modules.addressesPresentation
import manuelklyukvin.in_good_hands.build_src.modules.feedDomain
import manuelklyukvin.in_good_hands.build_src.modules.petsDomain
import manuelklyukvin.in_good_hands.build_src.modules.petsPresentation
import manuelklyukvin.in_good_hands.build_src.modules.postsDomain
import manuelklyukvin.in_good_hands.build_src.modules.postsPresentation

apply<PresentationGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.FEED
}

dependencies {
    feedDomain()

    postsDomain()
    postsPresentation()

    petsDomain()
    petsPresentation()

    addressesDomain()
    addressesPresentation()
}