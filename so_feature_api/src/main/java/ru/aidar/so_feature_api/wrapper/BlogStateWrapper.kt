package ru.aidar.so_feature_api.wrapper

import kotlinx.coroutines.flow.StateFlow

interface BlogStateWrapper {
    fun flow(): StateFlow<BlogState>
}
