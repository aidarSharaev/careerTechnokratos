package ru.aidar.menu_feature_impl.presentation

import android.util.Log
import ru.aidar.common.base.BaseViewModel
import ru.aidar.menu_feature_api.domain.MainMenuUseCases
import ru.aidar.menu_feature_impl.MenuRouter

class MainMenuViewModel(
    private val router: MenuRouter,
    private val mmUseCases: MainMenuUseCases,
) : BaseViewModel() {
    init {
        Log.d("ViewModelInstance", "init MainMenuViewModel")
    }

    override fun onCleared() {
        Log.d("ViewModelInstance", "clear MainMenuViewModel")
    }
}
