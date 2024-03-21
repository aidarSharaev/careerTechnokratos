package ru.aidar.so_feature_impl.presentation.blog

import ru.aidar.common.base.BaseViewModel
import ru.aidar.so_feature_impl.SoRouter
import ru.aidar.so_feature_api.domain.BlogUseCases
import ru.aidar.so_feature_api.wrapper.BlogStateWrapper

class BlogViewModel(
    private val router: SoRouter,
    private val useCases: BlogUseCases,
    private val wrapper: BlogStateWrapper,
) : BaseViewModel() {
}