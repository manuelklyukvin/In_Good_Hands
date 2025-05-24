import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DiGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.addressesData
import manuelklyukvin.in_good_hands.build_src.modules.addressesDomain
import manuelklyukvin.in_good_hands.build_src.modules.addressesPresentation
import manuelklyukvin.in_good_hands.build_src.modules.petsData
import manuelklyukvin.in_good_hands.build_src.modules.petsDomain
import manuelklyukvin.in_good_hands.build_src.modules.petsPresentation
import manuelklyukvin.in_good_hands.build_src.modules.postsData
import manuelklyukvin.in_good_hands.build_src.modules.postsDomain
import manuelklyukvin.in_good_hands.build_src.modules.postsPresentation
import manuelklyukvin.in_good_hands.build_src.modules.usersData
import manuelklyukvin.in_good_hands.build_src.modules.usersDomain
import manuelklyukvin.in_good_hands.build_src.modules.usersPresentation

apply<DiGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.POSTS
}

dependencies {
    postsData()
    postsDomain()
    postsPresentation()

    usersData()
    usersDomain()
    usersPresentation()

    petsData()
    petsDomain()
    petsPresentation()

    addressesData()
    addressesDomain()
    addressesPresentation()
}