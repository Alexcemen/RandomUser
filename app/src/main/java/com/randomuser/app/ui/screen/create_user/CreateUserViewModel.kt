package com.randomuser.app.ui.screen.create_user

import com.randomuser.app.ui.mvi.ScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class CreateUserViewModel @Inject constructor(
    reduce: CreateUserReduce,
) : ScreenViewModel<CreateUserStore.State, CreateUserStore.Event, CreateUserStore.SideEffect, CreateUserStore.Effect, CreateUserStore.UiState>(
    reduce
)
{
    override fun createState(): CreateUserStore.State = CreateUserStore.State()


    override fun handleEvent(
        currentState: CreateUserStore.State,
        intent: CreateUserStore.Event,
    ): Flow<CreateUserStore.Effect> = when (intent) {

        CreateUserStore.Event.Close -> flow {
            sendSideEffect(CreateUserStore.SideEffect.Close)
        }

        is CreateUserStore.Event.Generate -> flow {

        }

        is CreateUserStore.Event.SelectedGender -> flow {
            emit(CreateUserStore.Effect.SelectedGender(intent.gender))
        }

        is CreateUserStore.Event.SelectedNationality -> flow {
            emit(CreateUserStore.Effect.SelectedNationality(intent.nationality))
        }
    }

    override fun handleEffect(
        currentState: CreateUserStore.State,
        effect: CreateUserStore.Effect,
    ): CreateUserStore.State {
        return when(effect) {

            is CreateUserStore.Effect.SelectedGender -> currentState.copy(gender = effect.gender)

            is CreateUserStore.Effect.SelectedNationality -> currentState.copy(nationality = effect.nationality)

        }
    }
}