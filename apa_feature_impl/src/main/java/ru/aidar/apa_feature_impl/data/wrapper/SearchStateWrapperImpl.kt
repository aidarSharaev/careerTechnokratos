package ru.aidar.apa_feature_impl.data.wrapper

import kotlinx.coroutines.flow.MutableStateFlow
import ru.aidar.apa_feature_api.domain.wrappers.SearchState
import ru.aidar.apa_feature_api.domain.wrappers.SearchStateWrapper

class SearchStateWrapperImpl(
    private val flow: MutableStateFlow<SearchState>,
) : SearchStateWrapper
