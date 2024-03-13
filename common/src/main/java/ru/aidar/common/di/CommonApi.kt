package ru.aidar.common.di

import android.content.Context

interface CommonApi {

    fun applicationContext(): Context

    fun provideNetworkApiCreator(): NetworkApiCreator

    fun provideAppProperties(): AppProperties
}