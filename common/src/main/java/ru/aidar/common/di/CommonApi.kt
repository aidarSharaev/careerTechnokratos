package ru.aidar.common.di

import android.content.Context
import ru.aidar.common.core.auth.FirebaseManager
import ru.aidar.common.core.config.AppProperties
import ru.aidar.common.core.preferences.LocalManager
import ru.aidar.common.core.resources.ResourceManager
import ru.aidar.common.data.network.NetworkApiCreator
import ru.aidar.common.monitor.NetworkMonitor

interface CommonApi {
    fun applicationContext(): Context

    fun provideNetworkApiCreator(): NetworkApiCreator

    fun provideAppProperties(): AppProperties

    fun provideResourceManager(): ResourceManager

    fun provideLocalManager(): LocalManager

    fun provideFirebaseManager(): FirebaseManager

    fun provideNetworkMonitor(): NetworkMonitor
}
