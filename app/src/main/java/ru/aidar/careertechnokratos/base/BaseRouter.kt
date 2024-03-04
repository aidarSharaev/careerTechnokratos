package ru.aidar.careertechnokratos.base

interface ApodRouter {
    fun navigateToApodDestination()
    fun navigateToApodDetail()
}

interface NeoRouter {
    fun navigateToNeoDestination()
    fun navigateToNeoDetail()
}

interface ApaRouter {
    fun navigateToApaDestination()
    fun navigateToApaDetail()
}

interface SoRouter {
    fun navigateToSoDestination()
    fun navigateToPosts()
    fun navigateToPostDetail()
    fun navigateToTest()
}

interface ZhRouter {
    fun navigateToZhDestination()
    fun navigateToHistory()
    fun navigateToChat()
}