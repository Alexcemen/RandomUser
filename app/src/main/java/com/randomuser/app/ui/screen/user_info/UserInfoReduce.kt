package com.randomuser.app.ui.screen.user_info

import com.randomuser.app.ui.mvi.Reducer
import javax.inject.Inject

class UserInfoReduce @Inject constructor() :
    Reducer<UserInfoStore.State, UserInfoStore.UiState> {
    override fun reduce(state: UserInfoStore.State): UserInfoStore.UiState {
        return UserInfoStore.UiState(
            user = state.user
        )
    }
}