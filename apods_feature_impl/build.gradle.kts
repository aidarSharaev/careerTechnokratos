plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
    kotlin("plugin.serialization") version "1.8.10"
}

android {
    namespace = "ru.aidar.apods_feature_impl"
    compileSdk = rootProject.extra["compileSdk"] as Int

    defaultConfig {
        minSdk = rootProject.extra["minSdk"].toString().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(":common"))
    implementation(project(":apods_feature_api"))

    // navigation
    implementation(rootProject.extra["navFragmentDep"].toString())
    implementation(rootProject.extra["navUiDep"].toString())

    // compose
    debugImplementation(rootProject.extra["composeToolingDep"].toString())
    implementation(rootProject.extra["composeDep"].toString())
    implementation(rootProject.extra["composePreviewDep"].toString())
    implementation(rootProject.extra["composeFoundationDep"].toString())
    implementation(rootProject.extra["materialDep"].toString())

    // retrofit
    implementation(rootProject.extra["retrofitDep"].toString())
    implementation(rootProject.extra["serializationDep"].toString())

    // room
    implementation(rootProject.extra["roomRuntimeDep"].toString())
    annotationProcessor(rootProject.extra["roomKspDep"].toString())
    ksp(rootProject.extra["roomKspDep"].toString())
    implementation(rootProject.extra["roomKtxDep"].toString())
    implementation(rootProject.extra["roomPagingDep"].toString())
    implementation(rootProject.extra["roomToolKspDep"].toString())
    implementation(rootProject.extra["roomPagingComposeDep"].toString())

    // dagger
    implementation(rootProject.extra["daggerDep"].toString())
    ksp(rootProject.extra["daggerKspDep"].toString())

    // coil
    implementation("io.coil-kt:coil-compose:2.6.0")

    // Glance
    implementation("androidx.glance:glance-appwidget:1.0.0")
    implementation("androidx.glance:glance-material3:1.0.0")

    // work manager
    implementation ("androidx.work:work-runtime-ktx:2.9.0")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
