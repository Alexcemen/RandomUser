package com.example.randomuser.utils

import android.content.Context
import androidx.annotation.StringRes

class AppResourceImpl(private val context: Context) : AppResource {
    override fun getString(id: Int) = context.getString(id)
}


interface AppResource {
    fun getString(@StringRes id: Int): String
}