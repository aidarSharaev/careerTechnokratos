package ru.aidar.apa_feature_impl.di

import ru.aidar.common.core.preferences.LocalManager

interface ApaFeatureDependencies {

    fun localManager(): LocalManager
}
