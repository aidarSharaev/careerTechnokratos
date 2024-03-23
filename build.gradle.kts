buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.1")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
    }

    val compileSdk by extra { 34 }

    val minSdk by extra { 21 }
    val targetSdk by extra { 34 }
    val versionCode by extra { 1 }
    val versionName by extra { "1.0" }


    val coreVersion by extra { "1.12.0" }

    val appCompatVersion by extra { "1.6.1" }
    val activityVersion by extra { "1.8.2" }

    val daggerVersion by extra { "2.50" }

    val retrofitVersion by extra { "2.9.0" }
    val okhttpVersion by extra { "4.12.0" }
    val serializationVersion by extra { "1.6.0" }

    val composeVersion by extra { "1.6.3" }
    val materialVersion by extra { "1.2.1" }

    val constraintVersion by extra { "2.1.4" }

    val navigationVersion by extra { "2.7.7" }

    val firebaseVersion by extra { "22.3.1" }

    val viewModelVersion by extra { "2.7.0" }

    val splashVersion by extra { "1.0.1" }

    val dataStoreVersion by extra { "1.0.0" }

    val roomVersion by extra {"2.6.1"}
    val roomComposeVersion by extra {"3.2.1"}


    val coreDep by extra { "androidx.core:core-ktx:$coreVersion" }

    val activityDep by extra { "androidx.activity:activity-compose:$activityVersion" }
    val appCompatDep by extra { "androidx.appcompat:appcompat:$appCompatVersion" }

    val daggerDep by extra { "com.google.dagger:dagger:$daggerVersion" }
    val daggerKspDep by extra { "com.google.dagger:dagger-compiler:$daggerVersion" }

    val retrofitDep by extra { "com.squareup.retrofit2:retrofit:$retrofitVersion" }
    val retrofitConverterDep by extra { "com.squareup.retrofit2:converter-gson:$retrofitVersion" }
    val serializationDep by extra { "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion" }
    val okhttpDep by extra { "com.squareup.okhttp3:okhttp:$okhttpVersion" }
    val interceptorDep by extra { "com.squareup.okhttp3:logging-interceptor:$okhttpVersion" }

    val roomRuntimeDep by extra { "androidx.room:room-runtime:$roomVersion" }
    val roomKspDep by extra { "androidx.room:room-compiler:$roomVersion" }
    val roomKtxDep by extra { "androidx.room:room-ktx:$roomVersion" }
    val roomPagingDep by extra { "androidx.room:room-paging:$roomVersion" }
    val roomToolKspDep by extra { "com.google.devtools.ksp:symbol-processing-api:1.9.22-1.0.17" }
    val roomPagingComposeDep by extra { "androidx.paging:paging-compose:$roomComposeVersion" }

    val composeToolingDep by extra { "androidx.compose.ui:ui-tooling:$composeVersion" }
    val composeDep by extra { "androidx.compose.ui:ui:$composeVersion" }
    val composePreviewDep by extra { "androidx.compose.ui:ui-tooling-preview-android:$composeVersion" }
    val composeFoundationDep by extra { "androidx.compose.foundation:foundation-layout-android:$composeVersion" }
    val materialDep by extra { "androidx.compose.material3:material3:$materialVersion" }

    val constraintDep by extra { "androidx.constraintlayout:constraintlayout:$constraintVersion" }

    val navFragmentDep by extra { "androidx.navigation:navigation-fragment-ktx:$navigationVersion" }
    val navUiDep by extra { "androidx.navigation:navigation-ui-ktx:$navigationVersion" }

    val firebaseDep by extra { "com.google.firebase:firebase-auth:$firebaseVersion" }

    val viewModelDep by extra { "androidx.lifecycle:lifecycle-viewmodel-compose:$viewModelVersion" }

    val splashDep by extra { "androidx.core:core-splashscreen:$splashVersion" }

    val dataStoreDep by extra { "androidx.datastore:datastore-preferences:$dataStoreVersion" }
    val dataStoreCoreDep by extra { "androidx.datastore:datastore-preferences-core:$dataStoreVersion" }


}


plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.devtools.ksp") version "1.9.22-1.0.17" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.22" apply false
    id("com.android.library") version "8.2.2" apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
    id("org.jetbrains.kotlin.plugin.parcelize") version "1.9.22" apply false
}