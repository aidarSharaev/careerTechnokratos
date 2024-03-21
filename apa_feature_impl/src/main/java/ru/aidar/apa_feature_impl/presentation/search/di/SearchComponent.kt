package ru.aidar.apa_feature_impl.presentation.search.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.aidar.apa_feature_impl.presentation.search.SearchFragment
import ru.aidar.common.di.scope.apa.ApaScreenScope

@ApaScreenScope
@Subcomponent(modules = [SearchModule::class])
interface SearchComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
        ): SearchComponent
    }

    fun inject(fragment: SearchFragment)
}
