package ru.aidar.apods_feature_impl.di

import dagger.BindsInstance
import dagger.Component
import ru.aidar.apods_feature_api.di.ApodFeatureApi
import ru.aidar.apods_feature_impl.ApodRouter
import ru.aidar.apods_feature_impl.presentation.picture.di.PictureComponent
import ru.aidar.apods_feature_impl.presentation.list.di.ApodListComponent
import ru.aidar.common.data.db.di.DbApi
import ru.aidar.common.di.CommonApi
import ru.aidar.common.di.scope.apod.ApodFeatureScope

@ApodFeatureScope
@Component(
    dependencies = [ApodFeatureDependencies::class],
    modules = [ApodFeatureModule::class],
)
interface ApodFeatureComponent : ApodFeatureApi {
    fun apodListComponentFactory(): ApodListComponent.Factory

    fun pictureComponentFactory(): PictureComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun router(authRouter: ApodRouter): Builder

        fun withDependencies(deps: ApodFeatureDependencies): Builder

        fun build(): ApodFeatureComponent
    }

    @Component(
        dependencies = [
            CommonApi::class, DbApi::class,
        ],
    )
    interface ApodFeatureDependenciesComponent : ApodFeatureDependencies
}
