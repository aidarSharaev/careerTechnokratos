package ru.aidar.common.core.resources

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes resource: Int): String

    // todo check
    fun getStringArray(@ArrayRes id: Int): Array<String>

    fun getDrawable(@DrawableRes id: Int): Drawable?
}