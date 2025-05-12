import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DiGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.feedData
import manuelklyukvin.in_good_hands.build_src.modules.feedDomain
import manuelklyukvin.in_good_hands.build_src.modules.feedPresentation

apply<DiGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.FEED
}

dependencies {
    feedPresentation()
    feedDomain()
    feedData()
}