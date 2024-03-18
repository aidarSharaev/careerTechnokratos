package ru.aidar.careertechnokratos

import android.util.Log
import ru.aidar.common.base.BaseViewModel
import ru.aidar.common.core.auth.FirebaseManager

class MainViewModel(
    private val firebaseManager: FirebaseManager,
    // private val resourceManager: ResourceManager,
) : BaseViewModel() {
    init {
        Log.d("ViewModelInstance", "MainViewModel")
    }

    fun isUserAuthorized(): Boolean {
        return firebaseManager.getFbUser()?.let { true } ?: false
    }
}
