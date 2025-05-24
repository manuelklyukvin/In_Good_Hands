import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DiGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.addressesData
import manuelklyukvin.in_good_hands.build_src.modules.addressesDomain
import manuelklyukvin.in_good_hands.build_src.modules.addressesPresentation
import manuelklyukvin.in_good_hands.build_src.modules.feedData
import manuelklyukvin.in_good_hands.build_src.modules.feedDomain
import manuelklyukvin.in_good_hands.build_src.modules.feedPresentation
import manuelklyukvin.in_good_hands.build_src.modules.petsData
import manuelklyukvin.in_good_hands.build_src.modules.petsDomain
import manuelklyukvin.in_good_hands.build_src.modules.petsPresentation
import manuelklyukvin.in_good_hands.build_src.modules.postsData
import manuelklyukvin.in_good_hands.build_src.modules.postsDomain
import manuelklyukvin.in_good_hands.build_src.modules.postsPresentation

apply<DiGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.FEED
}

dependencies {
    feedData()
    feedDomain()
    feedPresentation()

    postsData()
    postsDomain()
    postsPresentation()

    petsData()
    petsDomain()
    petsPresentation()

    addressesData()
    addressesDomain()
    addressesPresentation()
}