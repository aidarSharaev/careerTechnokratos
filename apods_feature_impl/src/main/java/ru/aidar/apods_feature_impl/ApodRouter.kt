package ru.aidar.apods_feature_impl

import androidx.navigation.NavDirections

interface ApodRouter {
    fun navigateToApodDetail(action: NavDirections)

    fun apodNavigateUp()
}
