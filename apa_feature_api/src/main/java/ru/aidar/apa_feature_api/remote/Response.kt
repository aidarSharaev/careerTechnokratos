package ru.aidar.apa_feature_api.remote

data class Response(
    val code: Int,
    val data: List<ApaLocal>,
)
