package ru.aidar.so_feature_impl.presentation.blog.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.aidar.common.di.scope.so.SoScreenScope
import ru.aidar.so_feature_impl.presentation.blog.BlogFragment

@SoScreenScope
@Subcomponent(modules = [BlogModule::class])
interface BlogComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
        ): BlogComponent
    }

    fun inject(fragment: BlogFragment)
}
