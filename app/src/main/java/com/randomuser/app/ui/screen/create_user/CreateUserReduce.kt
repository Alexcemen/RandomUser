package com.randomuser.app.ui.screen.create_user

import com.randomuser.app.ui.mvi.Reducer
import javax.inject.Inject

class CreateUserReduce @Inject constructor() :
    Reducer<CreateUserStore.State, CreateUserStore.UiState> {
    override fun reduce(state: CreateUserStore.State): CreateUserStore.UiState {
        return CreateUserStore.UiState(
            gender = state.gender,
            nationality = state.nationality,
            isLoading = state.isLoading
        )
    }
}