package ru.aidar.auth_feature_impl.presentation.login.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.aidar.auth_feature_impl.presentation.login.LoginFragment
import ru.aidar.common.di.scope.auth.AuthScreenScope

@Subcomponent(modules = [LoginModule::class])
@AuthScreenScope
interface LoginComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
        ): LoginComponent
    }

    fun inject(fragment: LoginFragment)
}
