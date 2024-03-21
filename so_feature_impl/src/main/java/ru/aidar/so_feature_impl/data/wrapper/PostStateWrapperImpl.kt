package ru.aidar.so_feature_impl.data.wrapper

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.aidar.so_feature_api.wrapper.PostState
import ru.aidar.so_feature_api.wrapper.PostStateWrapper

class PostStateWrapperImpl(
    private val flow: MutableStateFlow<PostState>,
): PostStateWrapper {
    override fun flow(): StateFlow<PostState> {
        return flow
    }
}