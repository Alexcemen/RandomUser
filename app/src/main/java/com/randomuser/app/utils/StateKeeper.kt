package com.randomuser.app.utils

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import kotlin.takeIf


class StateKeeperImpl() : StateKeeper {
    init {
        Log.d("StateKeeper", "New instance created: ${this.hashCode()}")
    }
    private var _initialState: Bundle = bundleOf()

    override fun update(bundle: Bundle) {
        _initialState = bundle
    }

    override fun set(key: String, value: Int) {
        _initialState.putInt(key, value)
    }

    override fun getInt(key: String): Int? {
        return _initialState.getInt(key).takeIf { it != 0 }
    }

    override fun getAll(): Bundle = _initialState
}

interface StateKeeper {
    fun update(bundle: Bundle)
    fun set(key: String, value: Int)
    fun getInt(key: String): Int?
    fun getAll(): Bundle
}