package ru.aidar.menu_feature_api.di

import ru.aidar.menu_feature_api.domain.interfaces.MainMenuRepository
import ru.aidar.menu_feature_api.domain.interfaces.MainMenuUseCases

interface MainMenuFeatureApi {
    fun provideMmRepository(): MainMenuRepository

    fun provideMmUseCases(): MainMenuUseCases
}
