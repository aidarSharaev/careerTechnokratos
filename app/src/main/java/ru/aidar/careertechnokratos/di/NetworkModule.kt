package ru.aidar.careertechnokratos.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.aidar.careertechnokratos.remote.NasaRemoteDataSource
import ru.aidar.careertechnokratos.remote.NasaService

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
        nasaService: NasaService
    ): NasaRemoteDataSource {
        return NasaRemoteDataSource(nasaService = nasaService)
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
//        val contentType = "application/json".toMediaType()
//        val json = Json {
//            ignoreUnknownKeys = true
//        }
        return Retrofit.Builder()
            .baseUrl(NASA_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}

@Module
class ApiServiceModule {

    @Provides
    fun provideNasaService(retrofit: Retrofit): NasaService {
        return retrofit.create(NasaService::class.java)
    }

//    @Provides
//    fun provideSolarieService(retrofit: Retrofit): SolarieService {
//        return retrofit.create(SolarieService::class.java)
//    }
}