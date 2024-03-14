plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.8.10"
    id("com.google.devtools.ksp")
    id("com.google.gms.google-services")
}

android {
    namespace = "ru.aidar.careertechnokratos"
    compileSdk = rootProject.extra["compileSdk"] as Int

    defaultConfig {
        applicationId = "ru.aidar.careertechnokratos"
        minSdk = rootProject.extra["minSdk"] as Int
        targetSdk = rootProject.extra["targetSdk"] as Int
        versionCode = rootProject.extra["versionCode"] as Int
        versionName = rootProject.extra["versionName"] as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
}

dependencies {

    implementation(project(":common"))

    implementation(project(":apa_feature_api"))
    implementation(project(":apa_feature_impl"))

    implementation(project(":apods_feature_api"))
    implementation(project(":apods_feature_impl"))

    implementation(project(":chart_feature_api"))
    implementation(project(":chart_feature_impl"))

    implementation(project(":horoscope_feature_api"))
    implementation(project(":horoscope_feature_impl"))

    implementation(project(":login_feature_api"))
    implementation(project(":login_feature_impl"))

    implementation(project(":menu_feature_api"))
    implementation(project(":menu_feature_impl"))

    implementation(project(":spaceOverflow_feature_api"))
    implementation(project(":spaceOverflow_feature_impl"))

    implementation(project(":educationMenu_feature_api"))
    implementation(project(":educationMenu_feature_impl"))

    // core
    implementation(rootProject.extra["coreDep"].toString())

    // activity
    implementation(rootProject.extra["appCompatDep"].toString())
    implementation(rootProject.extra["activityDep"].toString())

    // compose
    debugImplementation(rootProject.extra["composeToolingDep"].toString())
    implementation(rootProject.extra["composeDep"].toString())
    implementation(rootProject.extra["composePreviewDep"].toString())
    implementation(rootProject.extra["composeFoundationDep"].toString())
    implementation(rootProject.extra["materialDep"].toString())

    // constraint
    implementation(rootProject.extra["constraintDep"].toString())

    // navigation
    implementation(rootProject.extra["navFragmentDep"].toString())
    implementation(rootProject.extra["navUiDep"].toString())

    //firebase
    implementation(rootProject.extra["firebaseDep"].toString())

    // viewmodel
    implementation(rootProject.extra["viewModelDep"].toString())

    // dagger
    implementation(rootProject.extra["daggerDep"].toString())
    ksp(rootProject.extra["daggerKspDep"].toString())

    // retrofit
    implementation(rootProject.extra["retrofitDep"].toString())
    implementation(rootProject.extra["retrofitConverterDep"].toString())
    implementation(rootProject.extra["serializationDep"].toString())
    implementation(rootProject.extra["okhttpDep"].toString())
    implementation(rootProject.extra["interceptorDep"].toString())

    // room
    implementation(rootProject.extra["roomRuntimeDep"].toString())
    annotationProcessor(rootProject.extra["roomKspDep"].toString())
    ksp(rootProject.extra["roomKspDep"].toString())
    implementation(rootProject.extra["roomKtxDep"].toString())
    implementation(rootProject.extra["roomPagingDep"].toString())
    implementation(rootProject.extra["roomToolKspDep"].toString())

    // test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


}