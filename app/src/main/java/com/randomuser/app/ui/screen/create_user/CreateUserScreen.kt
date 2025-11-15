package com.randomuser.app.ui.screen.create_user

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.randomuser.app.RootNavigation
import com.randomuser.app.ui.mvi.sideEffect
import com.randomuser.app.ui.screen.create_user.compose.CreateUserContent


@Composable
fun CreateUserScreenContent() {
    val rootNavigator = RootNavigation.current
    val viewModel = hiltViewModel<CreateUserViewModel>()

    viewModel.sideEffect { effect ->
        when(effect) {
            is CreateUserStore.SideEffect.Close -> {
                rootNavigator?.removeLastOrNull()
            }
        }
    }

    val state by viewModel.uiState.collectAsState()

    CreateUserContent(state, viewModel::onEvent)
}