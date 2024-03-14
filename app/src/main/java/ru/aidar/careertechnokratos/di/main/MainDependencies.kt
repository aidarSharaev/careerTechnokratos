package ru.aidar.careertechnokratos.di.main

import ru.aidar.careertechnokratos.di.deps.ComponentDependencies
import ru.aidar.careertechnokratos.navigation.Navigator

interface MainDependencies : ComponentDependencies {
    fun navigator(): Navigator
}
