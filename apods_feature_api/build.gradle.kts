plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation("androidx.paging:paging-common-ktx:3.2.1")
    runtimeOnly("androidx.lifecycle:lifecycle-common:2.7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation(rootProject.extra["retrofitDep"].toString())
}
