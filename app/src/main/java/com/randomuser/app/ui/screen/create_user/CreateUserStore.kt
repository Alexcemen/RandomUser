package com.randomuser.app.ui.screen.create_user

import com.randomuser.app.ui.mvi.MviEffect
import com.randomuser.app.ui.mvi.MviEvent
import com.randomuser.app.ui.mvi.MviSideEffect
import com.randomuser.app.ui.mvi.MviState
import com.randomuser.app.ui.mvi.MviUiState

object CreateUserStore {
    data class State(
        val gender: Gender = Gender.MALE,
        val nationality: Nationality = Nationality.UA
    ) : MviState

    data class UiState(
        val gender: Gender,
        val nationality: Nationality
    ) : MviUiState

    sealed interface SideEffect : MviSideEffect {
        data object Close : SideEffect
    }

    sealed interface Event : MviEvent {
        data class SelectedGender(val gender: Gender) : Event
        data class SelectedNationality(val nationality: Nationality) : Event
        data object Generate : Event
    }

    sealed interface Effect : MviEffect {

    }
}