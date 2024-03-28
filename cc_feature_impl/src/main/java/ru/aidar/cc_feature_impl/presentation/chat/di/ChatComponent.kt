package ru.aidar.cc_feature_impl.presentation.chat.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.aidar.cc_feature_impl.presentation.chat.ChatFragment
import ru.aidar.common.di.scope.cc.CcScreenScope

@Subcomponent(modules = [ChatModule::class])
@CcScreenScope
interface ChatComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
        ): ChatComponent
    }

    fun inject(fragment: ChatFragment)
}
