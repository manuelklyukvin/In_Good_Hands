import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.PresentationGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.feedDomain

apply<PresentationGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.FEED
}

dependencies {
    feedDomain()
}