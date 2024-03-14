package ru.aidar.common.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.aidar.common.data.network.dto.ApodDto

// todo add to raw.config
private const val NASA_API_KEY = "yruPHVQxgVnwCvVTLeMDA19F9QI4U7I8yHfkAIjB"

interface NasaServiceApi {
    @GET("/planetary/apod")
    suspend fun getApod(
        @Query("count") count: Int? = null,
        @Query("start_date") startDate: String? = null,
        @Query("end_date") endDate: String? = null,
        @Query("api_key") apiKey: String = NASA_API_KEY,
    ): List<ApodDto>
}
