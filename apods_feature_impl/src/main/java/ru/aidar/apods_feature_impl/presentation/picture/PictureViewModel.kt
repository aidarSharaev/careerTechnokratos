package ru.aidar.apods_feature_impl.presentation.picture

import ru.aidar.apods_feature_api.domain.interfaces.picture.PictureUseCases
import ru.aidar.apods_feature_impl.ApodRouter
import ru.aidar.common.base.BaseViewModel

class PictureViewModel(
    private val router: ApodRouter,
    private val useCases: PictureUseCases,
) : BaseViewModel() {
    fun navigateUp() {
        router.apodNavigateUp()
    }
}
