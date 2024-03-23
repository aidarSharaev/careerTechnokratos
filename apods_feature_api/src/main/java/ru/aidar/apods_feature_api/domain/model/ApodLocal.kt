package ru.aidar.apods_feature_api.domain.model


data class ApodLocal(
    val copyright: String?,
    val date: String,
    val explanation: String,
    val title: String,
    val url: String?,
)
