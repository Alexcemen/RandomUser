package com.randomuser.app.ui.screen.user_list

import androidx.lifecycle.viewModelScope
import com.randomuser.app.ui.mvi.ScreenViewModel
import com.randomuser.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    reduce: UserListReduce,
    private val userRepository: UserRepository,
) : ScreenViewModel<UserListStore.State, UserListStore.Event, UserListStore.SideEffect, UserListStore.Effect, UserListStore.UiState>(
    reduce
) {

    init {
        viewModelScope.launch {
            userRepository.getAllUsers().collect { allUsers ->
                forceEffect(
                    UserListStore.Effect.UpdateUsers(allUsers)
                )
            }
        }
    }


    override fun createState(): UserListStore.State = UserListStore.State()

    override fun handleEvent(
        currentState: UserListStore.State,
        intent: UserListStore.Event,
    ): Flow<UserListStore.Effect> = when (intent) {

        is UserListStore.Event.AddUser -> flow {
            sendSideEffect(UserListStore.SideEffect.OpenCreateUserContent)
        }

        is UserListStore.Event.ShowBottomSheet -> flow {
            emit(
                UserListStore.Effect.VisibleBottomSheet(
                    userId = intent.userId
                )
            )
        }

        is UserListStore.Event.CloseBottomSheet -> flow {
            if (currentState.bottomSheetId == -1) return@flow
            emit(
                UserListStore.Effect.VisibleBottomSheet(
                    userId = -1
                )
            )
        }

        is UserListStore.Event.DeleteUser -> flow {

        }

        is UserListStore.Event.OpenUserCard -> flow {

        }
    }

    override fun handleEffect(
        currentState: UserListStore.State,
        effect: UserListStore.Effect,
    ): UserListStore.State {
        return when (effect) {

            is UserListStore.Effect.UpdateUsers -> {
                currentState.copy(
                    users = effect.users
                )
            }

            is UserListStore.Effect.VisibleBottomSheet ->
                currentState.copy(
                    isVisibleBottomSheet = effect.userId != -1,
                    bottomSheetId = effect.userId
                )
        }
    }
}