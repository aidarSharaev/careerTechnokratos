package ru.aidar.so_feature_impl.di

import ru.aidar.common.core.auth.FirebaseManager

interface SoFeatureDependencies {

    fun firebaseManager(): FirebaseManager
}