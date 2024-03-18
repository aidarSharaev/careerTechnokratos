package ru.aidar.auth_feature_impl

import ru.aidar.common.base.BaseRouter

interface AuthRouter : BaseRouter {
    fun navigateToCreate()

    fun navigateToLogin()

    fun navigateToMenuGraph(
        graphId: Int,
        uri: String,
    )
}
