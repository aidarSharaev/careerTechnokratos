plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "ru.aidar.common"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(project(":app"))

    // core
    implementation(rootProject.extra["coreDep"].toString())

    // activity
    implementation(rootProject.extra["appCompatDep"].toString())

    // dagger
    implementation(rootProject.extra["daggerDep"].toString())
    implementation(rootProject.extra["daggerKspDep"].toString())

    // compose
    implementation(rootProject.extra["composeDep"].toString())

    // room
    implementation(rootProject.extra["roomRuntimeDep"].toString())
    annotationProcessor(rootProject.extra["roomKspDep"].toString())
    ksp(rootProject.extra["roomKspDep"].toString())
    implementation(rootProject.extra["roomKtxDep"].toString())
    implementation(rootProject.extra["roomPagingDep"].toString())
    implementation(rootProject.extra["roomToolKspDep"].toString())

    //retrofit
    implementation(rootProject.extra["retrofitDep"].toString())
    implementation(rootProject.extra["retrofitConverterDep"].toString())
    implementation(rootProject.extra["serializationDep"].toString())
    implementation(rootProject.extra["okhttpDep"].toString())
    implementation(rootProject.extra["interceptorDep"].toString())

    // test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}