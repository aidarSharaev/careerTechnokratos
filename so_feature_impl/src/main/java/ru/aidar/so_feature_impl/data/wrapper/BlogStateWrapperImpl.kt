package ru.aidar.so_feature_impl.data.wrapper

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.aidar.so_feature_api.wrapper.BlogState
import ru.aidar.so_feature_api.wrapper.BlogStateWrapper

class BlogStateWrapperImpl(
    private val flow: MutableStateFlow<BlogState>,
) : BlogStateWrapper {
    override fun flow(): StateFlow<BlogState> {
        return flow
    }
}
