package ru.aidar.so_feature_impl.presentation.post.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.common.di.viewmodel.ViewModelKey
import ru.aidar.common.di.viewmodel.ViewModelModule
import ru.aidar.so_feature_impl.SoRouter
import ru.aidar.so_feature_impl.presentation.post.PostViewModel
import ru.aidar.so_feature_api.domain.PostUseCases
import ru.aidar.so_feature_api.wrapper.PostStateWrapper

@Module(includes = [ViewModelModule::class])
class PostModule {
    @Provides
    fun provideViewModelProvider(
        fragment: Fragment,
        factory: ViewModelProvider.Factory,
    ): PostViewModel {
        return ViewModelProvider(fragment, factory)[PostViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    fun provideViewModel(
        router: SoRouter,
        useCases: PostUseCases,
        wrapper: PostStateWrapper,
    ): ViewModel {
        return PostViewModel(
            router = router,
            useCases = useCases,
            wrapper = wrapper,
        )
    }
}
