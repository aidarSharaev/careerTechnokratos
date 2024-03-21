package ru.aidar.so_feature_api.wrapper

import ru.aidar.so_feature_api.model.ScreenStatus

data class BlogState(
    val status: ScreenStatus = ScreenStatus.Visible,
)
