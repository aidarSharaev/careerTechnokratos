package ru.aidar.careertechnokratos.di.main

import ru.aidar.careertechnokratos.di.deps.ComponentDependencies
import ru.aidar.careertechnokratos.navigation.Navigator
import ru.aidar.common.core.auth.FirebaseManager

interface MainDependencies : ComponentDependencies {
    fun navigator(): Navigator

    fun fbAuth(): FirebaseManager
}
