plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation(rootProject.extra["composeDep"].toString())
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}
