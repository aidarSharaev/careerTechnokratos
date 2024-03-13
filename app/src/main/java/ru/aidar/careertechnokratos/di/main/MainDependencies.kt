package ru.aidar.careertechnokratos.di.main

import ru.aidar.careertechnokratos.base.Navigator
import ru.aidar.careertechnokratos.di.deps.ComponentDependencies

interface MainDependencies : ComponentDependencies {

    fun navigator(): Navigator
}