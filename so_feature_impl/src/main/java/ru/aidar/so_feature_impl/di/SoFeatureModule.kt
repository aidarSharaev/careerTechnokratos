package ru.aidar.so_feature_impl.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.aidar.auth_feature_impl.data.repository.BlogRepositoryImpl
import ru.aidar.auth_feature_impl.data.repository.PostRepositoryImpl
import ru.aidar.common.di.scope.so.SoFeatureScope
import ru.aidar.so_feature_impl.data.wrapper.BlogStateWrapperImpl
import ru.aidar.so_feature_impl.data.wrapper.PostStateWrapperImpl
import ru.aidar.so_feature_api.domain.BlogRepository
import ru.aidar.so_feature_api.domain.BlogUseCases
import ru.aidar.so_feature_api.domain.PostRepository
import ru.aidar.so_feature_api.domain.PostUseCases
import ru.aidar.so_feature_api.wrapper.BlogState
import ru.aidar.so_feature_api.wrapper.BlogStateWrapper
import ru.aidar.so_feature_api.wrapper.PostState
import ru.aidar.so_feature_api.wrapper.PostStateWrapper

@Module
class SoFeatureModule {
    @Provides
    @SoFeatureScope
    fun provideBlogRepository(
        repository: BlogRepositoryImpl
    ): BlogRepository = repository

    @Provides
    @SoFeatureScope
    fun provideBlogUseCases(
        repository: BlogRepository
    ): BlogUseCases {
        return BlogUseCases(repository = repository)
    }

    @Provides
    fun provideBlogState(): MutableStateFlow<BlogState> =
        MutableStateFlow(BlogState())

    @Provides
    fun provideBlogStateWrapper(
        flow: MutableStateFlow<BlogState>
    ): BlogStateWrapper {
        return BlogStateWrapperImpl(flow = flow)
    }

    /*@Provides
    @CcFeatureScope
    fun provideNasaServiceApi(networkApiCreator: NetworkApiCreator): NasaServiceApi {
        return networkApiCreator.getNasaService(service = NasaServiceApi::class.java)
    }*/

    @Provides
    @SoFeatureScope
    fun providePostRepository(
        repository: PostRepositoryImpl
    ): PostRepository = repository

    @Provides
    @SoFeatureScope
    fun providePostUseCases(
        repository: PostRepository
    ): PostUseCases {
        return PostUseCases(repository = repository)
    }

    @Provides
    fun providePostState(): MutableStateFlow<PostState> =
        MutableStateFlow(PostState())

    @Provides
    fun providePostStateWrapper(
        flow: MutableStateFlow<PostState>
    ): PostStateWrapper {
        return PostStateWrapperImpl(flow = flow)
    }
}