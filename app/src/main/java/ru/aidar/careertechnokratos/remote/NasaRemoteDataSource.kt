package ru.aidar.careertechnokratos.remote

import ru.aidar.common.remote.NasaServiceApi
import javax.inject.Inject

class NasaRemoteDataSource
    @Inject
    constructor(
        private val nasaServiceApi: NasaServiceApi,
    ) {
        // todo check null
        suspend fun get() = nasaServiceApi.getApod(startDate = "2024-02-24", endDate = "2024-02-27")
    }
