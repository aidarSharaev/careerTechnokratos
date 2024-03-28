package ru.aidar.cc_feature_impl.presentation.chat.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.cc_feature_api.domain.repository.ChatUseCases
import ru.aidar.cc_feature_api.domain.wrapper.ChatStateWrapper
import ru.aidar.cc_feature_impl.CcRouter
import ru.aidar.cc_feature_impl.presentation.chat.ChatViewModel
import ru.aidar.common.di.viewmodel.ViewModelKey
import ru.aidar.common.di.viewmodel.ViewModelModule

@Module(includes = [ViewModelModule::class])
class ChatModule {
    @Provides
    fun provideViewModelProvider(
        fragment: Fragment,
        factory: ViewModelProvider.Factory,
    ): ChatViewModel {
        return ViewModelProvider(fragment, factory)[ChatViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    fun provideViewModel(
        router: CcRouter,
        useCases: ChatUseCases,
        wrapper: ChatStateWrapper,
    ): ViewModel {
        return ChatViewModel(router = router, useCases = useCases, wrapper = wrapper)
    }
}
