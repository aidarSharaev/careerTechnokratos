package ru.aidar.apods_feature_impl.presentation.list.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.aidar.apods_feature_impl.presentation.list.ApodListFragment
import ru.aidar.common.di.scope.apod.ApodScreenScope

@Subcomponent(modules = [ApodListModule::class])
@ApodScreenScope
interface ApodListComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
        ): ApodListComponent
    }

    fun inject(fragment: ApodListFragment)
}
