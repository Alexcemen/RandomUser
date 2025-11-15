package com.randomuser.app.ui.navigation

import com.randomuser.app.ui.mvi.AppNavKey
import kotlinx.serialization.Serializable

@Serializable
data class SplashScreen(override val type: String = SplashScreen::class.simpleName.toString()) :
    AppNavKey()

@Serializable
data class CreateUser(override val type: String = CreateUser::class.simpleName.toString()) :
    AppNavKey()

@Serializable
data class UserList(override val type: String = UserList::class.simpleName.toString()) :
    AppNavKey()

@Serializable
data class UserDetails(override val type: String = UserDetails::class.simpleName.toString()) :
    AppNavKey()
