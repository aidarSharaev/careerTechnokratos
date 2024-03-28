package ru.aidar.menu_feature_impl.presentation.menu

import android.util.Log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import ru.aidar.common.base.BaseViewModel
import ru.aidar.menu_feature_api.domain.interfaces.MainMenuUseCases
import ru.aidar.menu_feature_api.domain.wrappers.MainMenuStateWrapper
import ru.aidar.menu_feature_api.domain.wrappers.ScreenStatus
import ru.aidar.menu_feature_impl.MenuRouter
import ru.aidar.menu_feature_impl.R
import kotlin.coroutines.CoroutineContext

class MainMenuViewModel(
    private val router: MenuRouter,
    private val useCases: MainMenuUseCases,
    private val wrapper: MainMenuStateWrapper,
) : BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + CoroutineName("MainMenuViewModel")

    init {
        Log.d("ViewModelInstance", "init MainMenuViewModel")
    }

    private fun navigateToLogin() {
        router.navigateToAuthGraph(R.id.menu_graph, "gpapp://auth_destination")
    }

    fun navigateToApod() {
        router.navigateInMenu("gpapp://apod_destination")
    }

    fun navigateToApa() {
        router.navigateInMenu("gpapp://apa_destination")
    }

    fun navigateToCc() {
        router.navigateInMenu("gpapp://cc_destination")
    }

    fun signOut() {
        wrapper.updateStatus(status = ScreenStatus.Loading)
        val result = useCases.signOut()
        if (result) {
            useCases.resetUser()
            navigateToLogin()
        } else {
            wrapper.updateStatus(status = ScreenStatus.Visible)
        }
    }

    override fun onCleared() {
        Log.d("ViewModelInstance", "clear MainMenuViewModel")
    }
}
