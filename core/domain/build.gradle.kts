import manuelklyukvin.in_good_hands.build_src.dependencies.testing

plugins {
    alias(libs.plugins.jvm)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    testing()
}