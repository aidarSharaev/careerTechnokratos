package ru.aidar.apa_feature_impl.presentation.search

import ru.aidar.apa_feature_api.domain.interfaces.SearchUseCases
import ru.aidar.apa_feature_api.domain.wrappers.SearchStateWrapper
import ru.aidar.apa_feature_impl.ApaRouter
import ru.aidar.common.base.BaseViewModel

class ApaSearchViewModel(
    private val router: ApaRouter,
    private val useCases: SearchUseCases,
    private val wrapper: SearchStateWrapper,
) : BaseViewModel() {

}

