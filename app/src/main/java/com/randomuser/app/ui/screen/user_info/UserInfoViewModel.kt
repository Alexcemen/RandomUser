package com.randomuser.app.ui.screen.user_info

import com.randomuser.app.ui.mvi.ScreenViewModel
import com.randomuser.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    reduce: UserInfoReduce,
    private val userRepository: UserRepository
) : ScreenViewModel<UserInfoStore.State, UserInfoStore.Event, UserInfoStore.SideEffect, UserInfoStore.Effect, UserInfoStore.UiState>(
    reduce
) {
    override fun createState(): UserInfoStore.State = UserInfoStore.State()

    override fun handleEvent(
        currentState: UserInfoStore.State,
        intent: UserInfoStore.Event,
    ): Flow<UserInfoStore.Effect> = when(intent) {

        is UserInfoStore.Event.Close -> flow {

        }
    }

    override fun handleEffect(
        currentState: UserInfoStore.State,
        effect: UserInfoStore.Effect,
    ): UserInfoStore.State {
        return when(effect) {

            is UserInfoStore.Effect.LoadUser -> currentState
        }
    }
}