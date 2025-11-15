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

        CreateUserStore.Event.Generate -> flow {

        }

        is CreateUserStore.Event.SelectedGender -> flow {

        }

        is CreateUserStore.Event.SelectedNationality -> flow {

        }
    }

    override fun handleEffect(
        currentState: CreateUserStore.State,
        effect: CreateUserStore.Effect,
    ): CreateUserStore.State {
        return CreateUserStore.State()
    }
}