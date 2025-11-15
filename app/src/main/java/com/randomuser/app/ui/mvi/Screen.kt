package com.randomuser.app.ui.mvi

import androidx.navigation3.runtime.NavKey

abstract class AppNavKey : NavKey {
    open val type: String = ""
}