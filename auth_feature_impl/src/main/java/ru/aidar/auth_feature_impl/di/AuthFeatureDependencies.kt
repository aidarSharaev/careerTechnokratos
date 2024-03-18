package ru.aidar.auth_feature_impl.di

import ru.aidar.common.core.auth.FirebaseManager

interface AuthFeatureDependencies {
    fun firebaseManager(): FirebaseManager
}
