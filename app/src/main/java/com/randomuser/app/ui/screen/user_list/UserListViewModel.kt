package com.randomuser.app.ui.screen.user_list

import com.randomuser.app.ui.mvi.ScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    reduce: UserListReduce
) : ScreenViewModel<UserListStore.State, UserListStore.Event, UserListStore.SideEffect, UserListStore.Effect, UserListStore.UiState>(
    reduce
) {
    override fun createState(): UserListStore.State = UserListStore.State()

    override fun handleEvent(
        currentState: UserListStore.State,
        intent: UserListStore.Event,
    ): Flow<UserListStore.Effect> = when(intent) {

        is UserListStore.Event.ShowBottomSheet -> flow {

        }

        is UserListStore.Event.AddUser -> flow {
            sendSideEffect(UserListStore.SideEffect.OpenCreateUserContent)
        }
    }

    override fun handleEffect(
        currentState: UserListStore.State,
        effect: UserListStore.Effect,
    ): UserListStore.State {
        return currentState
    }
}