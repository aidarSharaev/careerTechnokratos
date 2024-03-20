package ru.aidar.apods_feature_impl.di

import ru.aidar.common.core.preferences.LocalManager

interface ApodFeatureDependencies {

    fun localManager(): LocalManager
}