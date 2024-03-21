package ru.aidar.cc_feature_impl.presentation.cupid

import ru.aidar.cc_feature_api.domain.repository.CupidUseCases
import ru.aidar.cc_feature_impl.CcRouter
import ru.aidar.common.base.BaseViewModel

class CupidViewModel(
    private val router: CcRouter,
    private val useCases: CupidUseCases,
): BaseViewModel() {
}