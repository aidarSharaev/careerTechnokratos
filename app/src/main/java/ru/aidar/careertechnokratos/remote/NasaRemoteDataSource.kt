package ru.aidar.careertechnokratos.remote

import ru.aidar.careertechnokratos.model.NeoDto
import javax.inject.Inject

class NasaRemoteDataSource @Inject constructor(
    private val nasaService: NasaService
) {

    suspend fun get(): NeoDto {
        return nasaService.getNeoWs(startDate = "2024-02-27", endDate = "2024-02-27")
    }

}