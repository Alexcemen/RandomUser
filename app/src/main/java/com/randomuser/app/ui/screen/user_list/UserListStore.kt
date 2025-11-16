package com.randomuser.app.ui.screen.user_list

import com.randomuser.app.ui.models.UserUi
import com.randomuser.app.ui.mvi.MviEffect
import com.randomuser.app.ui.mvi.MviEvent
import com.randomuser.app.ui.mvi.MviSideEffect
import com.randomuser.app.ui.mvi.MviState
import com.randomuser.app.ui.mvi.MviUiState
import com.randomuser.domain.model.User

object UserListStore {
    data class State(
        val users: List<User> = emptyList(),
        val bottomSheetId: Int = -1,
        val isVisibleBottomSheet: Boolean = false,
        ) : MviState

    data class UiState(
        val users: List<UserUi>,
        val bottomSheetId: Int,
        val isVisibleBottomSheet: Boolean,
        ) : MviUiState

    sealed interface SideEffect : MviSideEffect {
        data object OpenCreateUserContent : SideEffect
        data object OpenUserInfo : SideEffect
    }

    sealed interface Event : MviEvent {
        data object AddUser : Event
        data class ShowBottomSheet(val userId: Int) : Event
        data object CloseBottomSheet : Event
        data class OpenUserCard(val userId: Int) : Event
        data class DeleteUser(val userId: Int) : Event
    }

    sealed interface Effect : MviEffect {
        data class UpdateUsers(val users: List<User>) : Effect
        data class VisibleBottomSheet(val userId: Int) : Effect
    }
}