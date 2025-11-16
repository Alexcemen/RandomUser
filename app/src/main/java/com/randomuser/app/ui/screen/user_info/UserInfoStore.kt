package com.randomuser.app.ui.screen.user_info

import com.randomuser.app.ui.models.UserUi
import com.randomuser.app.ui.models.enums.Nationality
import com.randomuser.app.ui.mvi.MviEffect
import com.randomuser.app.ui.mvi.MviEvent
import com.randomuser.app.ui.mvi.MviSideEffect
import com.randomuser.app.ui.mvi.MviState
import com.randomuser.app.ui.mvi.MviUiState
import com.randomuser.domain.model.User

object UserInfoStore {

    data class State(
        val user: UserUi = UserUi(
            userId = 0,
            firstName = "",
            lastName = "",
            phone = "",
            nationality = Nationality.UA,
            mediumPicture = ""
        )
    ) : MviState

    data class UiState(
        val user: UserUi
    ) : MviUiState

    sealed interface SideEffect : MviSideEffect {
        data object Close : SideEffect
    }

    sealed interface Event : MviEvent {
        data object Close : Event
    }

    sealed interface Effect : MviEffect {
        data class LoadUser(val user: User) : Effect
    }
}