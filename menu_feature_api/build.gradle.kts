plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation(rootProject.extra["composeDep"].toString())
}
