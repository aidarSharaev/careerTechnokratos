package ru.aidar.apa_feature_impl.data.repository

import android.util.Log
import ru.aidar.apa_feature_api.domain.interfaces.SearchRepository
import ru.aidar.apa_feature_api.remote.ApaLocal
import ru.aidar.apa_feature_api.remote.SolarieServiceApi
import javax.inject.Inject

class SearchRepositoryImpl
@Inject
constructor(
    private val service: SolarieServiceApi,
) : SearchRepository {

    override suspend fun getObjects(regex: String): List<ApaLocal> {
        // todo try catch
        val response = service.getBodies("englishName,sw,$regex")
        Log.d("getObjects", "-- ize == ${response.bodies?.size ?: "null"}")
        return response.bodies ?: listOf()
    }
}
