import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DiGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.petsData
import manuelklyukvin.in_good_hands.build_src.modules.petsDomain
import manuelklyukvin.in_good_hands.build_src.modules.petsPresentation

apply<DiGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.PETS
}

dependencies {
    petsData()
    petsDomain()
    petsPresentation()
}