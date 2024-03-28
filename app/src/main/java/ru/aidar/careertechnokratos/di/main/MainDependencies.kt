package ru.aidar.careertechnokratos.di.main

import com.google.firebase.firestore.FirebaseFirestore
import ru.aidar.careertechnokratos.di.deps.ComponentDependencies
import ru.aidar.careertechnokratos.navigation.Navigator
import ru.aidar.common.core.auth.FirebaseManager

interface MainDependencies : ComponentDependencies {
    fun navigator(): Navigator

    fun fbAuth(): FirebaseManager

    fun fbFirestore(): FirebaseFirestore
}
