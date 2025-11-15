package com.randomuser.app.ui.screen.user_list

import com.randomuser.app.ui.models.UserUi
import com.randomuser.app.ui.models.enums.Nationality
import com.randomuser.app.ui.mvi.Reducer
import javax.inject.Inject

class UserListReduce @Inject constructor() :
    Reducer<UserListStore.State, UserListStore.UiState> {
    override fun reduce(state: UserListStore.State): UserListStore.UiState {
        return UserListStore.UiState(
            users = state.users.map { user ->
                UserUi(
                    userId = user.localId,
                    firstName = user.name.first,
                    lastName = user.name.last,
                    phone = user.phone,
                    nationality = Nationality.valueOf(user.nat),
                    mediumPicture = user.picture.medium
                )
            }
        )
    }
}