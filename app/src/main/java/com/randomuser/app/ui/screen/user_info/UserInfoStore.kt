package com.randomuser.app.ui.screen.user_info

import com.randomuser.app.ui.models.LocationUi
import com.randomuser.app.ui.models.StreetUi
import com.randomuser.app.ui.models.UserInfoUi
import com.randomuser.app.ui.models.enums.UserInfoTab
import com.randomuser.app.ui.mvi.MviEffect
import com.randomuser.app.ui.mvi.MviEvent
import com.randomuser.app.ui.mvi.MviSideEffect
import com.randomuser.app.ui.mvi.MviState
import com.randomuser.app.ui.mvi.MviUiState
import com.randomuser.domain.model.User

object UserInfoStore {

    data class State(
        val user: UserInfoUi = UserInfoUi(
            firstName = "",
            lastName = "",
            gender = "",
            age = 0,
            dateOfBirth = "",
            phone = "",
            email = "",
            location = LocationUi(
                country = "",
                state = "",
                city = "",
                street = StreetUi(
                    number = 0,
                    name = ""
                ),
                postcode = ""
            ),
            picture = ""
        ),
        val selectedUserInfoTab: UserInfoTab = UserInfoTab.INFO
    ) : MviState

    data class UiState(
        val user: UserInfoUi,
        val selectedTab: UserInfoTab
    ) : MviUiState

    sealed interface SideEffect : MviSideEffect {
        data object Close : SideEffect
    }

    sealed interface Event : MviEvent {
        data object Close : Event
        data class OnTabClick(val tab: UserInfoTab) : Event
    }

    sealed interface Effect : MviEffect {
        data class LoadUser(val user: User) : Effect
        data class OnTabClick(val userInfoTab: UserInfoTab) : Effect
    }
}