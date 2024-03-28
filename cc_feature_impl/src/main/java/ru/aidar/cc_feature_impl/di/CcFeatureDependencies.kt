package ru.aidar.cc_feature_impl.di

import ru.aidar.common.core.auth.FirebaseManager

interface CcFeatureDependencies {

    fun firebaseManager(): FirebaseManager
}

