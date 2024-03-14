package ru.aidar.common.compose_component.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DropDownModel(
    @StringRes val text: Int,
    @DrawableRes val trailingImage: Int,
    val action: () -> Unit,
)
