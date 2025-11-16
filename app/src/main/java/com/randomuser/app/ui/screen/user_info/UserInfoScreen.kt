package com.randomuser.app.ui.screen.user_info

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.randomuser.app.RootNavigation
import com.randomuser.app.ui.mvi.sideEffect
import com.randomuser.app.ui.screen.user_info.compose.UserInfoContent

@Composable
fun UserInfoScreen() {
    val rootNavigator = RootNavigation.current
    val viewModel = hiltViewModel<UserInfoViewModel>()

    viewModel.sideEffect { effect ->
        when (effect) {
            is UserInfoStore.SideEffect.Close -> {
                rootNavigator?.removeLastOrNull()
            }
        }
    }

    val state by viewModel.uiState.collectAsState()

    UserInfoContent(state, viewModel::onEvent)
}