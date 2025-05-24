import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DataGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.menuDomain
import manuelklyukvin.in_good_hands.build_src.modules.usersData
import manuelklyukvin.in_good_hands.build_src.modules.usersDomain

apply<DataGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.MENU
}

dependencies {
    menuDomain()

    usersData()
    usersDomain()
}