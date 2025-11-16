package com.randomuser.app.ui.screen.create_user

import com.randomuser.app.ui.mvi.MviEffect
import com.randomuser.app.ui.mvi.MviEvent
import com.randomuser.app.ui.mvi.MviSideEffect
import com.randomuser.app.ui.mvi.MviState
import com.randomuser.app.ui.mvi.MviUiState
import com.randomuser.app.ui.models.enums.Gender
import com.randomuser.app.ui.models.enums.Nationality

object CreateUserStore {
    data class State(
        val gender: Gender = Gender.MALE,
        val nationality: Nationality = Nationality.UA,
        val isLoading: Boolean = false
    ) : MviState

    data class UiState(
        val gender: Gender,
        val nationality: Nationality,
        val isLoading: Boolean
    ) : MviUiState

    sealed interface SideEffect : MviSideEffect {
        data object Close : SideEffect
        data class ShowToast(val msg: String) : SideEffect
    }

    sealed interface Event : MviEvent {
        data object Close : Event
        data class SelectedGender(val gender: Gender) : Event
        data class SelectedNationality(val nationality: Nationality) : Event
        data object Generate : Event
    }

    sealed interface Effect : MviEffect {
        data class SelectedGender(val gender: Gender) : Effect
        data class SelectedNationality(val nationality: Nationality) : Effect
        object LoadingStarted : Effect
        object LoadingFinished : Effect
    }
}