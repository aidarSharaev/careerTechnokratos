package ru.aidar.menu_feature_impl

import androidx.annotation.IdRes

interface MenuRouter {
    fun navigateToAuthGraph(
        @IdRes graphId: Int,
        uri: String,
    )
}
