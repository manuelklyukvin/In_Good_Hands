import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.configs.GradleVersions
import manuelklyukvin.in_good_hands.build_src.dependencies.retrofit
import manuelklyukvin.in_good_hands.build_src.dependencies.testing
import manuelklyukvin.in_good_hands.build_src.modules.coreDomain

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
}

android {
    namespace = GradleNamespaces.CORE
    compileSdk = GradleVersions.COMPILE_SDK

    compileOptions {
        sourceCompatibility = GradleVersions.JAVA
        targetCompatibility = GradleVersions.JAVA
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    retrofit()
    testing()

    coreDomain()
}