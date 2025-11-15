package com.example.randomuser.ui.screen.create_user

import com.example.randomuser.ui.mvi.MviEffect
import com.example.randomuser.ui.mvi.MviEvent
import com.example.randomuser.ui.mvi.MviState
import com.example.randomuser.ui.mvi.MviUiState

object CreateUserState {
    data class State(
        val gender: Gender,
        val nationality: Nationality
    ) : MviState

    data class UiState(
        val gender: Gender,
        val nationality: Nationality
    ) : MviUiState

    sealed interface Event : MviEvent {
        data class SelectedGender(val gender: Gender) : Event
        data class SelectedNationality(val nationality: Nationality) : Event
        data object Generate : Event
    }

    sealed interface Effect : MviEffect {

    }
}