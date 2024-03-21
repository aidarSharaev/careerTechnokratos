package ru.aidar.apa_feature_impl.presentation.detail.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.aidar.apa_feature_impl.presentation.detail.DetailFragment
import ru.aidar.common.di.scope.apa.ApaScreenScope

@ApaScreenScope
@Subcomponent(modules = [DetailModule::class])
interface DetailComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
        ): DetailComponent
    }

    fun inject(fragment: DetailFragment)
}
