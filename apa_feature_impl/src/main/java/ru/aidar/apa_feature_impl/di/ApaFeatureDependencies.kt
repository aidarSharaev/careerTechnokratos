package ru.aidar.apa_feature_impl.di

import ru.aidar.common.core.preferences.LocalManager
import ru.aidar.common.data.network.NetworkApiCreator
import ru.aidar.common.monitor.NetworkMonitor

interface ApaFeatureDependencies {

    fun networkApiCreator(): NetworkApiCreator

    fun networkMonitor(): NetworkMonitor

    fun localManager(): LocalManager
}
