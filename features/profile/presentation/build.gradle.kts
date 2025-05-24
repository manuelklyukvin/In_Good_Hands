import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.PresentationGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.profileDomain
import manuelklyukvin.in_good_hands.build_src.modules.usersDomain
import manuelklyukvin.in_good_hands.build_src.modules.usersPresentation

apply<PresentationGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.PROFILE
}

dependencies {
    profileDomain()

    usersDomain()
    usersPresentation()
}