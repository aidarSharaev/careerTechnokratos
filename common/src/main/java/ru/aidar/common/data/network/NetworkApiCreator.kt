package ru.aidar.common.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkApiCreator(
    private val okHttpClient: OkHttpClient,
    private val nasaUrl: String,
    private val solarieUrl: String,
    // private val horoscopeUrl: String,
    // private val testUrl: String,
    // private val calenderUrl: String,
) {
    fun <T> getNasaService(service: Class<T>): T {
        return create(url = nasaUrl, service = service)
    }

    fun <T> getSolarieService(service: Class<T>): T {
        return create(url = solarieUrl, service = service)
    }

    private fun <T> create(
        url: String,
        service: Class<T>,
    ): T {
        val retrofit =
            Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(service)
    }
}
