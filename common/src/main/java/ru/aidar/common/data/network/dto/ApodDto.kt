package ru.aidar.common.data.network.dto

import com.google.gson.annotations.SerializedName

// todo check id
data class ApodDto(
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("date")
    val date: String,
    @SerializedName("explanation")
    val explanation: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    val id: Long = 0,
)
