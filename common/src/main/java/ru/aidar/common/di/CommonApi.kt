package ru.aidar.common.di

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import ru.aidar.common.core.config.AppProperties
import ru.aidar.common.core.resources.ResourceManager
import ru.aidar.common.data.network.NetworkApiCreator

interface CommonApi {

    fun applicationContext(): Context

    fun provideNetworkApiCreator(): NetworkApiCreator

    fun provideAppProperties(): AppProperties

    fun provideResourceManager(): ResourceManager

    fun provideFirebaseAuth(): FirebaseAuth
}