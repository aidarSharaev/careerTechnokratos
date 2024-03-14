package ru.aidar.careertechnokratos.di.deps

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.aidar.careertechnokratos.GalaxyPulseApplication
import ru.aidar.common.data.db.di.DbApi
import ru.aidar.common.data.db.di.DbHolder
import ru.aidar.common.di.FeatureApiHolder
import ru.aidar.common.di.FeatureContainer
import ru.aidar.common.di.scope.ApplicationScope

@Module
interface ComponentHolderModule {

    @ApplicationScope
    @Binds
    fun provideFeatureContainer(application: GalaxyPulseApplication): FeatureContainer

    // todo
//    @ApplicationScope
//    @Binds
//    @ClassKey(UserFeatureApi::class)
//    @IntoMap
//    fun provideUserFeatureHolder(userFeatureHolder: UserFeatureHolder): FeatureApiHolder
//
//    @ApplicationScope
//    @Binds
//    @ClassKey(DbApi::class)
//    @IntoMap
//    fun provideDbFeature(dbHolder: DbHolder): FeatureApiHolder
}