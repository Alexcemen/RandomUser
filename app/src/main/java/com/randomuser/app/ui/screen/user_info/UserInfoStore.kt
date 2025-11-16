package com.randomuser.app.ui.screen.user_info

import com.randomuser.app.ui.models.UserInfoUi
import com.randomuser.app.ui.models.enums.UserInfoTab
import com.randomuser.app.ui.mvi.MviEffect
import com.randomuser.app.ui.mvi.MviEvent
import com.randomuser.app.ui.mvi.MviSideEffect
import com.randomuser.app.ui.mvi.MviState
import com.randomuser.app.ui.mvi.MviUiState
import com.randomuser.domain.model.Coordinates
import com.randomuser.domain.model.Dob
import com.randomuser.domain.model.Location
import com.randomuser.domain.model.Login
import com.randomuser.domain.model.Name
import com.randomuser.domain.model.Picture
import com.randomuser.domain.model.Registered
import com.randomuser.domain.model.Street
import com.randomuser.domain.model.Timezone
import com.randomuser.domain.model.User
import com.randomuser.domain.model.UserId

object UserInfoStore {

    data class State(
        val user: User = User(
            localId = 0,
            gender = "",
            name = Name(
                title = "",
                first = "",
                last = ""
            ),
            location = Location(
                street = Street(number = 0, name = ""),
                city = "",
                state = "",
                country = "",
                postcode = "",
                coordinates = Coordinates(latitude = "", longitude = ""),
                timezone = Timezone(offset = "", description = "")
            ),
            email = "",
            login = Login(
                uuid = "",
                username = "",
                password = "",
                salt = "",
                md5 = "",
                sha1 = "",
                sha256 = ""
            ),
            dob = Dob(
                date = "",
                age = 0
            ),
            registered = Registered(
                date = "",
                age = 0
            ),
            phone = "",
            cell = "",
            userId = UserId(
                name = "",
                value = ""
            ),
            picture = Picture(
                large = "",
                medium = "",
                thumbnail = ""
            ),
            nat = ""
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