package ru.aidar.apa_feature_api.remote

import ru.aidar.apa_feature_api.remote.ApaLocal

data class Response(
    val code: Int,
    val data: List<ApaLocal>,
)