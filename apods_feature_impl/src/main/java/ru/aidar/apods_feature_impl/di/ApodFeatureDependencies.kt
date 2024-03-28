package ru.aidar.apods_feature_impl.di

import ru.aidar.common.core.preferences.LocalManager
import ru.aidar.common.data.db.local.GalaxyPulseDatabase
import ru.aidar.common.data.network.NetworkApiCreator

interface ApodFeatureDependencies {
    fun networkApiCreator(): NetworkApiCreator

    fun db(): GalaxyPulseDatabase

    fun localManager(): LocalManager
}
