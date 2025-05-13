package manuelklyukvin.in_good_hands.build_src.gradle_plugins

import manuelklyukvin.in_good_hands.build_src.configs.GradleVersions
import manuelklyukvin.in_good_hands.build_src.dependencies.koin
import manuelklyukvin.in_good_hands.build_src.dependencies.retrofit
import manuelklyukvin.in_good_hands.build_src.modules.coreData
import manuelklyukvin.in_good_hands.build_src.modules.coreDomain
import manuelklyukvin.in_good_hands.build_src.modules.corePresentation
import manuelklyukvin.in_good_hands.build_src.plugins.Plugins
import manuelklyukvin.in_good_hands.build_src.utils.android
import org.gradle.api.Project

class DiGradlePlugin : CoreGradlePlugin() {
    override fun applyPlugins(project: Project) {
        project.apply {
            plugin(Plugins.ANDROID_LIBRARY)
            plugin(Plugins.KOTLIN)
        }
    }

    override fun applyProjectConfigs(project: Project) {
        project.android().apply {
            compileSdk = GradleVersions.COMPILE_SDK

            compileOptions {
                sourceCompatibility = GradleVersions.JAVA
                targetCompatibility = GradleVersions.JAVA
            }
        }
    }

    override fun applyDependencies(project: Project) {
        project.dependencies.apply {
            koin()
            retrofit()

            coreData()
            coreDomain()
            corePresentation()
        }
    }

    override fun applyTesting(project: Project) = Unit
}