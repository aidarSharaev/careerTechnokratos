package ru.aidar.common.core.config

import android.content.Context
import ru.aidar.common.R
import java.util.Properties

@Suppress("UNCHECKED_CAST")
class AppProperties(private val context: Context) {
    private val properties: Map<String, String> = initProperties(context)

    private fun initProperties(context: Context): Map<String, String> {
        return context.resources.openRawResource(R.raw.config).use {
            val properties = Properties()
            properties.load(it)
            properties as Map<String, String>
        }
    }

    fun networkProperties(): NetworkProperties {
        val connectTimeout = properties["http.timeout.connect"]?.toLong() ?: 0
        val readTimeout = properties["http.timeout.read"]?.toLong() ?: 0
        val writeTimeout = properties["http.timeout.write"]?.toLong() ?: 0
        return NetworkProperties(connectTimeout, readTimeout, writeTimeout)
    }

    // TODO
    fun getNasaUrl(): String = properties["nasa_url"] ?: ""
}
