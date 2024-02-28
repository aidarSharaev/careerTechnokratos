package ru.aidar.careertechnokratos.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.aidar.careertechnokratos.model.CustomDeserializer
import ru.aidar.careertechnokratos.model.NeoCloud
import ru.aidar.careertechnokratos.remote.NasaRemoteDataSource
import ru.aidar.careertechnokratos.remote.NasaServiceApi

private const val NASA_URL = "https://api.nasa.gov"
private const val SOLARIE_URL = "https://api.le-systeme-solaire.net"

/**
 * TODO
 *
 * проверить gson
 * */

@Module(
    includes = [NetworkModule::class]
)
object DataSources {

    @Provides
    fun provideNasaDataSource(
        nasaServiceApi: NasaServiceApi
    ): NasaRemoteDataSource {
        return NasaRemoteDataSource(nasaServiceApi = nasaServiceApi)
    }

}


@Module(
    includes = [ApiServiceModule::class]
)
object NetworkModule {

    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor = httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        val gson = GsonBuilder()
            .registerTypeAdapter(NeoCloud::class.java, CustomDeserializer())
            .create()
        return Retrofit.Builder()
            .baseUrl(NASA_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }
}

@Module
class ApiServiceModule {

    @Provides
    fun provideNasaService(retrofit: Retrofit): NasaServiceApi {
        return retrofit.create(NasaServiceApi::class.java)
    }

//    @Provides
//    fun provideSolarieService(retrofit: Retrofit): SolarieService {
//        return retrofit.create(SolarieService::class.java)
//    }
}