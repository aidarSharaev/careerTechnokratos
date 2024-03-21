package ru.aidar.cc_feature_impl.data.wrapper

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.aidar.cc_feature_api.domain.wrapper.CupidState
import ru.aidar.cc_feature_api.domain.wrapper.CupidStateWrapper

class CupidStateWrapperImpl(
    private val flow: MutableStateFlow<CupidState>
): CupidStateWrapper {
    override fun flow(): StateFlow<CupidState> {
        return flow
    }
}