package com.example.randomuser.ui.navigation

import com.example.randomuser.ui.mvi.AppNavKey
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
