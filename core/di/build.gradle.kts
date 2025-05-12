import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DiGradlePlugin

apply<DiGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.CORE
}