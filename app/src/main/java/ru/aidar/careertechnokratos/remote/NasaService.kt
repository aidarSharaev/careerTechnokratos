package ru.aidar.careertechnokratos.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.aidar.careertechnokratos.base.BaseApi
import ru.aidar.careertechnokratos.model.ApodDto
import ru.aidar.careertechnokratos.model.NeoDto

private const val NASA_API_KEY = "yruPHVQxgVnwCvVTLeMDA19F9QI4U7I8yHfkAIjB"

private const val apodValue = "/planetary/apod"
private const val neoWsValue = "/neo/rest/v1/feed"


/**
 * TODO
 * проверить на пустоту и на ошибки
 */

interface NasaService : BaseApi {

    @GET(apodValue)
    suspend fun getApod(
        @Query("count") count: Int = 20,
        @Query("start_date") startDate: String? = null,
        @Query("end_date") endDate: String? = null,
        @Query("api_key") apiKey: String = NASA_API_KEY,
    ): List<ApodDto>

    @GET("/neo/rest/v1/feed")
    suspend fun getNeoWs(
        @Query("start_date") startDate: String? = null,
        @Query("end_date") endDate: String? = null,
        @Query("api_key") apiKey: String = NASA_API_KEY,
    ): NeoDto
}