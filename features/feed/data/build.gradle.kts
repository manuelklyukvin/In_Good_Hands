import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DataGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.addressesData
import manuelklyukvin.in_good_hands.build_src.modules.addressesDomain
import manuelklyukvin.in_good_hands.build_src.modules.feedDomain
import manuelklyukvin.in_good_hands.build_src.modules.petsData
import manuelklyukvin.in_good_hands.build_src.modules.petsDomain
import manuelklyukvin.in_good_hands.build_src.modules.postsData
import manuelklyukvin.in_good_hands.build_src.modules.postsDomain

apply<DataGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.FEED
}

dependencies {
    feedDomain()

    postsData()
    postsDomain()

    petsData()
    petsDomain()

    addressesData()
    addressesDomain()
}