package ru.aidar.careertechnokratos.di

import android.content.Context
import okhttp3.OkHttpClient

interface CommonApi {

    fun applicationContext(): Context

    fun provideNetworkApiCreator(): NetworkApiCreator

}

// TODO

class NetworkApiCreator(
    private val okHttpClient: OkHttpClient,
    private val nasaUrl: String,
    private val solarieUrl: String,
    private val horoscopeUrl: String,
    private val testUrl: String,
    private val calenderUrl: String,
)