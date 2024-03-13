package ru.aidar.common.core.resources

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

class ResourceManagerImpl(
    private val context: Context
): ResourceManager {
    override fun getString(resource: Int): String {
        return context.getString(resource)
    }

    override fun getStringArray(id: Int): Array<String> {
        return context.resources.getStringArray(id)
    }

    override fun getDrawable(id: Int): Drawable? {
        return ContextCompat.getDrawable(context, id)
    }
}