package com.randomuser.app.ui.navigation

import com.randomuser.app.ui.mvi.AppNavKey
import kotlinx.serialization.Serializable

@Serializable
data class SplashScreen(override val type: String = SplashScreen::class.simpleName.toString()) :
    AppNavKey()

@Serializable
data class CreateUserKey(override val type: String = CreateUserKey::class.simpleName.toString()) :
    AppNavKey()

@Serializable
data class UserListKey(override val type: String = UserListKey::class.simpleName.toString()) :
    AppNavKey()

@Serializable
data class UserDetailsKey(override val type: String = UserDetailsKey::class.simpleName.toString()) :
    AppNavKey()
