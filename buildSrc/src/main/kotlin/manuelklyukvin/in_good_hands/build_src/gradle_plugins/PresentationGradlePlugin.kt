package manuelklyukvin.in_good_hands.build_src.gradle_plugins

import manuelklyukvin.in_good_hands.build_src.configs.GradleVersions
import manuelklyukvin.in_good_hands.build_src.dependencies.androidx
import manuelklyukvin.in_good_hands.build_src.dependencies.koin
import manuelklyukvin.in_good_hands.build_src.modules.coreDomain
import manuelklyukvin.in_good_hands.build_src.modules.corePresentation
import manuelklyukvin.in_good_hands.build_src.plugins.Plugins
import manuelklyukvin.in_good_hands.build_src.utils.android
import org.gradle.api.Project

class PresentationGradlePlugin : CoreGradlePlugin() {
    override fun applyPlugins(project: Project) {
        project.apply {
            plugin(Plugins.ANDROID_LIBRARY)
            plugin(Plugins.KOTLIN)
            plugin(Plugins.COMPOSE)
        }
    }

    override fun applyProjectConfigs(project: Project) {
        project.android().apply {
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
    }

    override fun applyDependencies(project: Project) {
        project.dependencies.apply {
            androidx()
            koin()

            corePresentation()
            coreDomain()
        }
    }
}