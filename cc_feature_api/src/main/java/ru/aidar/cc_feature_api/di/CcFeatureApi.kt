package ru.aidar.cc_feature_api.di

import ru.aidar.cc_feature_api.domain.repository.ChatRepository
import ru.aidar.cc_feature_api.domain.repository.ChatUseCases

interface CcFeatureApi {

    fun provideChatRepository(): ChatRepository

    fun provideChatUseCases(): ChatUseCases
}
