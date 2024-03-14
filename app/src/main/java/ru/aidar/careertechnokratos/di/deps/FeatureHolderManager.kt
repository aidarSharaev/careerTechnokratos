package ru.aidar.careertechnokratos.di.deps

import ru.aidar.common.di.FeatureApiHolder

class FeatureHolderManager(
    private val mFeatureHolders: Map<Class<*>, FeatureApiHolder>,
) {

    fun <T> getFeature(key: Class<*>): T? {
        val featureApiHolder = mFeatureHolders[key] ?: throw IllegalStateException()
        return featureApiHolder.getFeatureApi<T>()
    }

    fun releaseFeature(key: Class<*>) {
        val featureApiHolder = mFeatureHolders[key] ?: throw IllegalStateException()
        featureApiHolder.releaseFeatureApi()
    }
}
