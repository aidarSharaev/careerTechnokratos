plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation(rootProject.extra["retrofitConverterDep"].toString())
    implementation(rootProject.extra["serializationDep"].toString())
    implementation(rootProject.extra["retrofitDep"].toString())
}
