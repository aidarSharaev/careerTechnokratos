package ru.aidar.careertechnokratos.base

import androidx.navigation.NavController
import ru.aidar.apa_feature_impl.ApaRouter
import ru.aidar.apod_feature_impl.ApodRouter
import ru.aidar.careertechnokratos.R
import ru.aidar.educationmenu_feature_impl.SoRouter
import ru.aidar.horoscope_feature_impl.CcRouter


class Navigator : AppRouter() {

    override var gpNavController: NavController? = null

    override fun attachNavController(navController: NavController, graph: Int) {
        navController.setGraph(graph)
        gpNavController = navController
    }

    override fun detachNavController(navController: NavController) {
        if(gpNavController == navController) {
            gpNavController = null
        }
    }

    override fun navigateToApodDestination() {
        gpNavController?.navigate(R.id.action_mainMenu_to_apodDestination)
    }

    override fun navigateToApodDetail() {
        //
    }

    override fun navigateToApaDestination() {
        // TODO("Not yet implemented")
    }

    override fun navigateToApaDetail() {
        //TODO("Not yet implemented")
    }

    override fun navigateToSoDestination() {
        //TODO("Not yet implemented")
    }

    override fun navigateToPosts() {
        //TODO("Not yet implemented")
    }

    override fun navigateToPostDetail() {
        //TODO("Not yet implemented")
    }

    override fun navigateToTest() {
        //TODO("Not yet implemented")
    }

    override fun navigateToCcDestination() {
        //TODO("Not yet implemented")
    }

    override fun navigateToChat() {
        //TODO("Not yet implemented")
    }
}

abstract class AppRouter : ApodRouter, ApaRouter, SoRouter, CcRouter {

    protected abstract var gpNavController: NavController?
    abstract fun attachNavController(navController: NavController, graph: Int)
    abstract fun detachNavController(navController: NavController)
}
