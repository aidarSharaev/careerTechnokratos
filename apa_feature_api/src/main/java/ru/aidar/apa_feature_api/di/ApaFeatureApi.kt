package ru.aidar.apa_feature_api.di

import ru.aidar.apa_feature_api.domain.interfaces.DetailRepository
import ru.aidar.apa_feature_api.domain.interfaces.DetailUseCases
import ru.aidar.apa_feature_api.domain.interfaces.SearchRepository
import ru.aidar.apa_feature_api.domain.interfaces.SearchUseCases

interface ApaFeatureApi {

    fun provideSearchRepository(): SearchRepository

    fun provideDetailRepository(): DetailRepository

    fun provideSearchUseCases(): SearchUseCases

    fun provideDetailUseCases(): DetailUseCases
}
