package com.randomuser.app.ui.screen.create_user

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.randomuser.app.RootNavigation
import com.randomuser.app.ui.mvi.sideEffect
import com.randomuser.app.ui.screen.create_user.compose.CreateUserContent
import com.randomuser.app.utils.showError


@Composable
fun CreateUserScreen() {
    val rootNavigator = RootNavigation.current
    val viewModel = hiltViewModel<CreateUserViewModel>()
    val context = LocalContext.current

    viewModel.sideEffect { effect ->
        when(effect) {
            is CreateUserStore.SideEffect.Close -> {
                rootNavigator?.removeLastOrNull()
            }

            is CreateUserStore.SideEffect.ShowToast -> {
                context.showError(effect.msg)
            }
        }
    }

    val state by viewModel.uiState.collectAsState()

    CreateUserContent(state, viewModel::onEvent)
}