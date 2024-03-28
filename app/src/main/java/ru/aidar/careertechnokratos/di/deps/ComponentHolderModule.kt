package ru.aidar.careertechnokratos.di.deps

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.aidar.apa_feature_api.di.ApaFeatureApi
import ru.aidar.apa_feature_impl.di.ApaFeatureHolder
import ru.aidar.apods_feature_api.di.ApodFeatureApi
import ru.aidar.apods_feature_impl.di.ApodFeatureHolder
import ru.aidar.auth_feature_api.di.AuthFeatureApi
import ru.aidar.auth_feature_impl.di.AuthFeatureHolder
import ru.aidar.careertechnokratos.GalaxyPulseApplication
import ru.aidar.cc_feature_api.di.CcFeatureApi
import ru.aidar.cc_feature_impl.di.CcFeatureHolder
import ru.aidar.common.data.db.local.di.DbApi
import ru.aidar.common.data.db.local.di.DbHolder
import ru.aidar.common.di.FeatureApiHolder
import ru.aidar.common.di.FeatureContainer
import ru.aidar.common.di.scope.app.ApplicationScope
import ru.aidar.menu_feature_api.di.MainMenuFeatureApi
import ru.aidar.menu_feature_impl.di.MainMenuFeatureHolder

@Module
interface ComponentHolderModule {
    @ApplicationScope
    @Binds
    fun provideFeatureContainer(
        application: GalaxyPulseApplication,
    ): FeatureContainer

    @ApplicationScope
    @Binds
    @ClassKey(MainMenuFeatureApi::class)
    @IntoMap
    fun provideUserFeatureHolder(
        mainMenuFeatureHolder: MainMenuFeatureHolder,
    ): FeatureApiHolder

    @ApplicationScope
    @Binds
    @ClassKey(AuthFeatureApi::class)
    @IntoMap
    fun provideAuthFeatureHolder(
        authFeatureHolder: AuthFeatureHolder,
    ): FeatureApiHolder

    @ApplicationScope
    @Binds
    @ClassKey(ApodFeatureApi::class)
    @IntoMap
    fun provideApodFeatureHolder(
        apodFeatureHolder: ApodFeatureHolder,
    ): FeatureApiHolder

    @ApplicationScope
    @Binds
    @ClassKey(ApaFeatureApi::class)
    @IntoMap
    fun provideApaFeatureHolder(
        apaFeatureHolder: ApaFeatureHolder,
    ): FeatureApiHolder

    @ApplicationScope
    @Binds
    @ClassKey(CcFeatureApi::class)
    @IntoMap
    fun provideCcFeatureHolder(
        ccFeatureHolder: CcFeatureHolder,
    ): FeatureApiHolder

    @ApplicationScope
    @Binds
    @ClassKey(DbApi::class)
    @IntoMap
    fun provideDbFeature(
        dbHolder: DbHolder,
    ): FeatureApiHolder
}
