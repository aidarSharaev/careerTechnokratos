package ru.aidar.careertechnokratos.remote

import ru.aidar.careertechnokratos.model.NeoDto
import javax.inject.Inject

class NasaRemoteDataSource @Inject constructor(
    private val nasaService: NasaService
) {

    suspend fun get(): NeoDto {
        return nasaService.getNeoWs(start_date = "2024-02-27", end_date = "2024-02-27")
    }

}