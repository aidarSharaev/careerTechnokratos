package ru.aidar.careertechnokratos.navigation

import android.net.Uri
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavGraph
import ru.aidar.apa_feature_impl.ApaRouter
import ru.aidar.apods_feature_impl.ApodRouter
import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.cc_feature_impl.CcRouter
import ru.aidar.menu_feature_impl.MenuRouter
import ru.aidar.so_feature_impl.SoRouter

class Navigator() : MenuRouter, ApodRouter, ApaRouter, CcRouter, AuthRouter, SoRouter {

    private var appNavController: NavController? = null

    fun attachNavController(
        navController: NavController,
        graph: NavGraph?,
    ) {
        navController.setGraph(graph!!, null)
        appNavController = navController
    }

    fun detachNavController(navController: NavController) {
        if(appNavController == navController) {
            appNavController = null
        }
    }

    override fun navigateToMenuGraph(
        @IdRes graphId: Int,
        uri: String,
    ) {
        appNavController?.popBackStack(graphId, true)
        appNavController?.navigate(Uri.parse(uri))
    }

    override fun navigateToAuthGraph(
        @IdRes graphId: Int,
        uri: String,
    ) {
        appNavController?.popBackStack(graphId, true)
        navigateInMenu(uri = uri)
    }

    override fun navigateInMenu(uri: String) {
        appNavController?.navigate(Uri.parse(uri))
    }

    override fun navigateToCreate() {
        appNavController?.navigate(
            ru.aidar.auth_feature_impl.R.id.action_loginFragment_to_createAccountFragment,
            null,
        )
    }

    override fun navigateToLogin() {
        appNavController?.navigate(
            ru.aidar.auth_feature_impl.R.id.action_createAccountFragment_to_loginFragment,
            null,
        )
    }

    override fun navigateToApodDetail(action: NavDirections) {
        appNavController?.navigate(action)
    }

    override fun apodNavigateUp() {
        appNavController?.popBackStack()
    }

    override fun apaNavigateUp() {
        appNavController?.popBackStack()
    }

    override fun navigateToApaDetail(action: NavDirections) {
        appNavController?.navigate(action)
    }
}
