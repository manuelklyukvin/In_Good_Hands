import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DiGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.profileData
import manuelklyukvin.in_good_hands.build_src.modules.profileDomain
import manuelklyukvin.in_good_hands.build_src.modules.profilePresentation
import manuelklyukvin.in_good_hands.build_src.modules.usersData
import manuelklyukvin.in_good_hands.build_src.modules.usersDomain
import manuelklyukvin.in_good_hands.build_src.modules.usersPresentation

apply<DiGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.PROFILE
}

dependencies {
    profileData()
    profileDomain()
    profilePresentation()

    usersData()
    usersDomain()
    usersPresentation()
}