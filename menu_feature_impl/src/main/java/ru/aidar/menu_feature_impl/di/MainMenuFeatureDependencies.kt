package ru.aidar.menu_feature_impl.di

import ru.aidar.common.core.auth.FirebaseManager
import ru.aidar.common.core.preferences.LocalManager

interface MainMenuFeatureDependencies {
    fun localManager(): LocalManager

    fun firebaseManager(): FirebaseManager
}
