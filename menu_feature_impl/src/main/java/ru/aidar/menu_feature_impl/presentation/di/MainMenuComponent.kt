package ru.aidar.menu_feature_impl.presentation.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.aidar.common.di.scope.MainMenuScreenScope
import ru.aidar.menu_feature_impl.presentation.MainMenuFragment

@Subcomponent(modules = [MainMenuModule::class])
@MainMenuScreenScope
interface MainMenuComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
        ): MainMenuComponent
    }

    fun inject(fragment: MainMenuFragment)
}
