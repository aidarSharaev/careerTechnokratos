package ru.aidar.apa_feature_impl.presentation.detail

import ru.aidar.apa_feature_api.domain.interfaces.DetailUseCases
import ru.aidar.apa_feature_api.domain.wrappers.DetailStateWrapper
import ru.aidar.apa_feature_impl.ApaRouter
import ru.aidar.common.base.BaseViewModel

class ApaDetailViewModel(
    private val router: ApaRouter,
    private val useCases: DetailUseCases,
    private val wrapper: DetailStateWrapper,
) : BaseViewModel() {
    fun navigateUp() {
        router.apaNavigateUp()
    }
}
