package ru.aidar.common.di.modules

import android.util.Log
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ru.aidar.common.core.config.AppProperties
import ru.aidar.common.core.config.NetworkProperties
import ru.aidar.common.data.network.NetworkApiCreator
import ru.aidar.common.di.scope.app.ApplicationScope
import java.util.concurrent.TimeUnit

// private const val SOLARIE_URL = "https://api.le-systeme-solaire.net"

@Module
class NetworkModule {
    @Provides
    @ApplicationScope
    fun provideNetworkProperties(appProperties: AppProperties): NetworkProperties {
        return appProperties.networkProperties()
    }

    @Provides
    @ApplicationScope
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    // todo @ApplicationScope?
    @Provides
    @ApplicationScope
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        networkProperties: NetworkProperties,
    ): OkHttpClient {
        Log.d("ProvidesOkhttpClient", "invoke")
        return OkHttpClient.Builder()
            .addInterceptor(interceptor = httpLoggingInterceptor)
            .connectTimeout(networkProperties.connectTimeout, TimeUnit.SECONDS)
            .writeTimeout(networkProperties.writeTimeout, TimeUnit.SECONDS)
            .readTimeout(networkProperties.readTimeout, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideApiCreator(
        okHttpClient: OkHttpClient,
        appProperties: AppProperties,
    ): NetworkApiCreator {
        return NetworkApiCreator(
            okHttpClient = okHttpClient,
            nasaUrl = appProperties.getNasaUrl(),
        )
    }
}
