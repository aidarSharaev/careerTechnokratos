package ru.aidar.cc_feature_impl.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.aidar.cc_feature_api.domain.repository.ChatRepository
import ru.aidar.cc_feature_api.domain.repository.ChatUseCases
import ru.aidar.cc_feature_api.domain.wrapper.ChatState
import ru.aidar.cc_feature_api.domain.wrapper.ChatStateWrapper
import ru.aidar.cc_feature_impl.data.repository.ChatRepositoryImpl
import ru.aidar.cc_feature_impl.data.wrapper.ChatStateWrapperImpl
import ru.aidar.common.di.scope.cc.CcFeatureScope

@Module
class CcFeatureModule {
    @Provides
    @CcFeatureScope
    fun provideChatRepository(repository: ChatRepositoryImpl): ChatRepository = repository

    @Provides
    @CcFeatureScope
    fun provideChatUseCases(repository: ChatRepository): ChatUseCases {
        return ChatUseCases(repository = repository)
    }

    @Provides
    fun provideChatState(): MutableStateFlow<ChatState> = MutableStateFlow(ChatState())

    @Provides
    fun provideChatStateWrapper(flow: MutableStateFlow<ChatState>): ChatStateWrapper {
        return ChatStateWrapperImpl(flow = flow)
    }

    /*@Provides
    @CcFeatureScope
    fun provideNasaServiceApi(networkApiCreator: NetworkApiCreator): NasaServiceApi {
        return networkApiCreator.getNasaService(service = NasaServiceApi::class.java)
    }*/
}
