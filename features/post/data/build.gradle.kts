import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DataGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.postDomain

apply<DataGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.POST
}

dependencies {
    postDomain()
}