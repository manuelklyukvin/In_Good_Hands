import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DiGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.menuData
import manuelklyukvin.in_good_hands.build_src.modules.menuDomain
import manuelklyukvin.in_good_hands.build_src.modules.menuPresentation
import manuelklyukvin.in_good_hands.build_src.modules.usersData
import manuelklyukvin.in_good_hands.build_src.modules.usersDomain
import manuelklyukvin.in_good_hands.build_src.modules.usersPresentation

apply<DiGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.MENU
}

dependencies {
    menuData()
    menuDomain()
    menuPresentation()

    usersData()
    usersDomain()
    usersPresentation()
}