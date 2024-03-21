package ru.aidar.cc_feature_api.di

import ru.aidar.cc_feature_api.domain.repository.CupidRepository
import ru.aidar.cc_feature_api.domain.repository.CupidUseCases

interface CcFeatureApi {

    fun provideCupidRepository(): CupidRepository

    fun provideCupidUseCases(): CupidUseCases
}