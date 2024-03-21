package ru.aidar.cc_feature_api.domain.wrapper

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface CupidStateWrapper {

    fun flow(): StateFlow<CupidState>
}