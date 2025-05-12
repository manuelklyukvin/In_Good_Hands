import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.gradle_plugins.DiGradlePlugin
import manuelklyukvin.in_good_hands.build_src.modules.postData
import manuelklyukvin.in_good_hands.build_src.modules.postDomain
import manuelklyukvin.in_good_hands.build_src.modules.postPresentation

apply<DiGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = GradleNamespaces.POST
}

dependencies {
    postPresentation()
    postDomain()
    postData()
}