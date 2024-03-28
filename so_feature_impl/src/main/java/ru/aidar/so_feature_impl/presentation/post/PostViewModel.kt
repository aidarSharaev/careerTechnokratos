package ru.aidar.so_feature_impl.presentation.post

import ru.aidar.common.base.BaseViewModel
import ru.aidar.so_feature_api.domain.PostUseCases
import ru.aidar.so_feature_api.wrapper.PostStateWrapper
import ru.aidar.so_feature_impl.SoRouter

class PostViewModel(
    private val router: SoRouter,
    private val useCases: PostUseCases,
    private val wrapper: PostStateWrapper,
) : BaseViewModel()
