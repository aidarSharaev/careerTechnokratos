package ru.aidar.auth_feature_impl.presentation.create.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.aidar.auth_feature_impl.presentation.create.CreateAccountFragment
import ru.aidar.common.di.scope.auth.AuthScreenScope

@AuthScreenScope
@Subcomponent(modules = [CreateModule::class])
interface CreateComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
        ): CreateComponent
    }

    fun inject(fragment: CreateAccountFragment)
}
