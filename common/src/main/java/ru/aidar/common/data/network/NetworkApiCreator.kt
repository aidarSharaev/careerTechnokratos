package ru.aidar.common.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.aidar.apod_feature_impl.remote.NasaServiceApi

// TODO изменить юрлки
class NetworkApiCreator(
    private val okHttpClient: OkHttpClient,
    private val nasaUrl: String,
    //private val solarieUrl: String,
    //private val horoscopeUrl: String,
    //private val testUrl: String,
    //private val calenderUrl: String,
) {

    private fun <T> nasaCreate(): NasaServiceApi {
        return create(url = nasaUrl, NasaServiceApi::class.java)
    }

    private fun <T> create(url: String, service: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(service)
    }
}
