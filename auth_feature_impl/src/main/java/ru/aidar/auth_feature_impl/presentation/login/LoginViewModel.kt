package ru.aidar.auth_feature_impl.presentation.login

import android.util.Log
import ru.aidar.auth_feature_api.domain.interfaces.LoginUseCases
import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.common.base.BaseViewModel
import ru.aidar.signin_feature_impl.R

class LoginViewModel(
    private val loginUseCases: LoginUseCases,
    private val router: AuthRouter,
) : BaseViewModel() {

    fun navigateToCreate() {
        router.navigateToCreate()
    }

    fun navigateToMenuGraph() {
        router.navigateToMenuGraph(R.id.auth_graph, "gpapp://menu_destination")
    }

    init {
        Log.d("ViewModelInstance", "init LoginViewModel")
    }

    override fun onCleared() {
        Log.d("ViewModelInstance", "clear LoginViewModel")
        super.onCleared()
    }
}
