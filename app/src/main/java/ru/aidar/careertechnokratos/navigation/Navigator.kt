package ru.aidar.careertechnokratos.navigation

import androidx.navigation.NavController
import ru.aidar.apa_feature_impl.ApaRouter
import ru.aidar.apods_feature_impl.ApodRouter
import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.careertechnokratos.R
import ru.aidar.cc_feature_impl.CcRouter
import ru.aidar.menu_feature_impl.MenuRouter
import ru.aidar.spaceoverflow_feature_impl.SoRouter

class Navigator : MenuRouter, ApodRouter, ApaRouter, CcRouter, AuthRouter, SoRouter {
    private var appNavController: NavController? = null

    fun attachNavController(
        navController: NavController,
        graph: Int,
    ) {
        navController.setGraph(graph)
        appNavController = navController
    }

    fun detachNavController(navController: NavController) {
        if (appNavController == navController) {
            appNavController = null
        }
    }

    override fun navigateToApod() {
        appNavController?.navigate(R.id.action_mainMenu_to_apodFeature, null)
    }
}
