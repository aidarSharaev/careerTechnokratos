package ru.aidar.apa_feature_impl.data.wrapper

import kotlinx.coroutines.flow.MutableStateFlow
import ru.aidar.apa_feature_api.domain.wrappers.DetailState
import ru.aidar.apa_feature_api.domain.wrappers.DetailStateWrapper

class DetailStateWrapperImpl(
    private val flow: MutableStateFlow<DetailState>,
) : DetailStateWrapper
