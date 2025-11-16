package com.randomuser.app.ui.screen.user_info

import androidx.lifecycle.viewModelScope
import com.randomuser.app.ui.models.LocationUi
import com.randomuser.app.ui.models.StreetUi
import com.randomuser.app.ui.models.UserInfoUi
import com.randomuser.app.ui.mvi.ScreenViewModel
import com.randomuser.app.utils.KeeperKeys
import com.randomuser.app.utils.StateKeeper
import com.randomuser.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import java.time.Instant
import java.time.ZoneId


@HiltViewModel
class UserInfoViewModel @Inject constructor(
    reduce: UserInfoReduce,
    private val keeper: StateKeeper,
    private val userRepository: UserRepository,
) : ScreenViewModel<UserInfoStore.State, UserInfoStore.Event, UserInfoStore.SideEffect, UserInfoStore.Effect, UserInfoStore.UiState>(
    reduce
) {
    init {
        viewModelScope.launch {
            val userId = keeper.getInt(KeeperKeys.USER_ID_BUNDLE) ?: return@launch
            val user = userRepository.getUserById(userId) ?: return@launch
            forceEffect(UserInfoStore.Effect.LoadUser(user))
        }
    }


    override fun createState(): UserInfoStore.State = UserInfoStore.State()

    override fun handleEvent(
        currentState: UserInfoStore.State,
        intent: UserInfoStore.Event,
    ): Flow<UserInfoStore.Effect> = when (intent) {

        is UserInfoStore.Event.Close -> flow {
            sendSideEffect(UserInfoStore.SideEffect.Close)
        }

        is UserInfoStore.Event.OnTabClick -> flow {
            forceEffect(UserInfoStore.Effect.OnTabClick(intent.tab))
        }
    }

    override fun handleEffect(
        currentState: UserInfoStore.State,
        effect: UserInfoStore.Effect,
    ): UserInfoStore.State {
        return when (effect) {

            is UserInfoStore.Effect.LoadUser ->
                currentState.copy(
                    user = UserInfoUi(
                        firstName = effect.user.name.first,
                        lastName = effect.user.name.last,
                        gender = effect.user.gender,
                        age = effect.user.dob.age,
                        dateOfBirth = formatDate(effect.user.dob.date),
                        phone = effect.user.phone,
                        email = effect.user.email,
                        location = LocationUi(
                            street = StreetUi(
                                name = effect.user.location.street.name,
                                number = effect.user.location.street.number
                            ),
                            city = effect.user.location.city,
                            state = effect.user.location.state,
                            country = effect.user.location.country,
                            postcode = effect.user.location.postcode
                        ),
                        picture = effect.user.picture.medium
                    )
                )

            is UserInfoStore.Effect.OnTabClick ->
                currentState.copy(
                    selectedUserInfoTab = effect.userInfoTab
                )
        }
    }
}

private fun formatDate(date: String): String {
    return try {
        Instant.parse(date)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
            .toString()
    } catch (e: Exception) {
        date
    }
}