package ru.aidar.menu_feature_api.di

import ru.aidar.menu_feature_api.domain.MainMenuRepository
import ru.aidar.menu_feature_api.domain.MainMenuUseCases

interface MainMenuFeatureApi {

    fun provideMmRepository(): MainMenuRepository

    fun provideMmUseCases(): MainMenuUseCases
}
