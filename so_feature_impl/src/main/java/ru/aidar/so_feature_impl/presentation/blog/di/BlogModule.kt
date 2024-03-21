package ru.aidar.so_feature_impl.presentation.blog.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.common.di.viewmodel.ViewModelKey
import ru.aidar.common.di.viewmodel.ViewModelModule
import ru.aidar.so_feature_impl.SoRouter
import ru.aidar.so_feature_impl.presentation.blog.BlogViewModel
import ru.aidar.so_feature_api.domain.BlogUseCases
import ru.aidar.so_feature_api.wrapper.BlogStateWrapper

@Module(includes = [ViewModelModule::class])
class BlogModule {
    @Provides
    fun provideViewModelProvider(
        fragment: Fragment,
        factory: ViewModelProvider.Factory,
    ): BlogViewModel {
        return ViewModelProvider(fragment, factory)[BlogViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(BlogViewModel::class)
    fun provideViewModel(
        router: SoRouter,
        useCases: BlogUseCases,
        wrapper: BlogStateWrapper,
    ): ViewModel {
        return BlogViewModel(
            router = router,
            useCases = useCases,
            wrapper = wrapper,
        )
    }
}
