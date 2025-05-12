import manuelklyukvin.in_good_hands.build_src.configs.GradleNamespaces
import manuelklyukvin.in_good_hands.build_src.configs.GradleVersions
import manuelklyukvin.in_good_hands.build_src.dependencies.androidx
import manuelklyukvin.in_good_hands.build_src.dependencies.coil
import manuelklyukvin.in_good_hands.build_src.dependencies.navigation
import manuelklyukvin.in_good_hands.build_src.dependencies.serialization
import manuelklyukvin.in_good_hands.build_src.dependencies.testing
import manuelklyukvin.in_good_hands.build_src.modules.coreDomain

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose)
    alias(libs.plugins.serialization)
}

android {
    namespace = GradleNamespaces.CORE
    compileSdk = GradleVersions.COMPILE_SDK

    buildTypes {
        release {
            isMinifyEnabled = true
        }
    }
    compileOptions {
        sourceCompatibility = GradleVersions.JAVA
        targetCompatibility = GradleVersions.JAVA
    }
    buildFeatures {
        compose = true
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    androidx()
    serialization()
    navigation()
    coil()
    testing()

    coreDomain()
}