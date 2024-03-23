package ru.aidar.apods_feature_impl.presentation.picture.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.aidar.apods_feature_impl.presentation.picture.PictureFragment
import ru.aidar.common.di.scope.apod.ApodScreenScope

@Subcomponent(modules = [PictureModule::class])
@ApodScreenScope
interface PictureComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
        ): PictureComponent
    }

    fun inject(fragment: PictureFragment)
}
