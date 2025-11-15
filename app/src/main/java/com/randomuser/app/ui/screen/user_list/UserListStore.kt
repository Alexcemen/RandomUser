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
        val users: List<User> = emptyList()
    ) : MviState

    data class UiState(
        val users: List<UserUi>
    ) : MviUiState

    sealed interface SideEffect : MviSideEffect {
    }

    sealed interface Event : MviEvent {
        data class ShowBottomSheet(val userId: Int) : Event
    }

    sealed interface Effect : MviEffect {

    }
}