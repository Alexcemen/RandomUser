package com.randomuser.app.ui.screen.user_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.randomuser.app.RootNavigation
import com.randomuser.app.ui.mvi.sideEffect
import com.randomuser.app.ui.navigation.CreateUser
import com.randomuser.app.ui.screen.user_list.compose.UserListContent

@Composable
fun UserListScreen() {
    val rootNavigator = RootNavigation.current
    val viewModel = hiltViewModel<UserListViewModel>()

    viewModel.sideEffect { effect ->
        when (effect) {

            is UserListStore.SideEffect.OpenCreateUserContent -> {
                rootNavigator?.add(CreateUser())
            }

        }
    }

    val state by viewModel.uiState.collectAsState()

    UserListContent(state, viewModel::onEvent)
}