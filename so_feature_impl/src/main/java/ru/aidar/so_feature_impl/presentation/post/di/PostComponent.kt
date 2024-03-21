package ru.aidar.so_feature_impl.presentation.blog.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.aidar.common.di.scope.so.SoScreenScope
import ru.aidar.so_feature_impl.presentation.post.PostFragment
import ru.aidar.so_feature_impl.presentation.post.di.PostModule

@SoScreenScope
@Subcomponent(modules = [PostModule::class])
interface PostComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment,
        ): PostComponent
    }

    fun inject(fragment: PostFragment)
}
