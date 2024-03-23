package ru.aidar.apa_feature_api.remote

import retrofit2.http.GET
import retrofit2.http.Query


interface SolarieServiceApi {

    @GET("bodies")
    suspend fun getBodies(
        @Query("filter[]") filter: List<String>
    ): List<ApaLocal>
}