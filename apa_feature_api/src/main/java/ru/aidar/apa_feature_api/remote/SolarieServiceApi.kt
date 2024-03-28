package ru.aidar.apa_feature_api.remote

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Query

interface SolarieServiceApi {
    @GET("/rest/bodies")
    suspend fun getBodies(
        @Query("filter[]") filter: String/*listOf("id", "sw", "ven")*/,
        @Query("order") order: String = "id,asc",
        @Query("page") page: String = "1,10",
    ): Bodies
}

data class Bodies(
    @SerializedName("bodies")
    val bodies: List<ApaLocal>?,
)
