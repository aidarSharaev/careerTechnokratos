package ru.aidar.so_feature_api.wrapper

import kotlinx.coroutines.flow.StateFlow

interface PostStateWrapper {
    fun flow(): StateFlow<PostState>

}
