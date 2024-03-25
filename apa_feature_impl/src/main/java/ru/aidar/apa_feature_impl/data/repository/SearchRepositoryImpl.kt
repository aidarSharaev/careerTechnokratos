package ru.aidar.apa_feature_impl.data.repository

import ru.aidar.apa_feature_api.domain.interfaces.SearchRepository
import ru.aidar.apa_feature_api.remote.SolarieServiceApi
import ru.aidar.apa_feature_api.remote.Response
import ru.aidar.common.core.error.ResponseCode
import javax.inject.Inject

class SearchRepositoryImpl
@Inject
constructor(
    private val service: SolarieServiceApi,
) : SearchRepository {

    override suspend fun getObjects(regex: String): Response {
        // todo try catch
        return try {
            val response = service.getBodies("englishName,sw,$regex")
            Response(
                code = ResponseCode.Success.code,
                data = response.bodies ?: throw Exception()
            )
        } catch(e: Exception) {
            Response(code = ResponseCode.Fail.code, data = listOf())
        }
    }
}
