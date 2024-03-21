package ru.aidar.cc_feature_impl.presentation.cupid.di

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Subcomponent
import ru.aidar.cc_feature_impl.presentation.cupid.CupidFragment
import ru.aidar.common.di.scope.cc.CcScreenScope

@Subcomponent(modules = [CupidModule::class])
@CcScreenScope
interface CupidComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance fragment: Fragment
        ): CupidComponent
    }

    fun inject(fragment: CupidFragment)
}