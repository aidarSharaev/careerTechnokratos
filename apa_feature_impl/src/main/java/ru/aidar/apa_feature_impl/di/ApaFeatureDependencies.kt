package ru.aidar.apa_feature_impl.di

import ru.aidar.common.core.preferences.LocalManager
import ru.aidar.common.data.network.NetworkApiCreator

interface ApaFeatureDependencies {

    fun networkApiCreator(): NetworkApiCreator

    fun localManager(): LocalManager
}
