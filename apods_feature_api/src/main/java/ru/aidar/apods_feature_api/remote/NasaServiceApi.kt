package ru.aidar.apods_feature_api.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.aidar.apods_feature_api.domain.model.ApodLocal

interface NasaServiceApi {
    companion object {
        private const val NASA_API_KEY = "yruPHVQxgVnwCvVTLeMDA19F9QI4U7I8yHfkAIjB"
    }

    @GET("/planetary/apod")
    suspend fun getApod(
        @Query("count") count: Int? = null,
        @Query("start_date") startDate: String? = null,
        @Query("end_date") endDate: String? = null,
        @Query("api_key") apiKey: String = NASA_API_KEY,
    ): List<ApodLocal>

    /*@GET("/apod/image/{id}/{url}")
    suspend fun getPictureBytes(
        @Path("id") id: String,
        @Path("url") url: String,
    ): Response<ResponseBody>*/
}
