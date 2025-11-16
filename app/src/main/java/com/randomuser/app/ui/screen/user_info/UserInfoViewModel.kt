package com.randomuser.app.ui.screen.user_info

import androidx.lifecycle.viewModelScope
import com.randomuser.app.ui.models.UserUi
import com.randomuser.app.ui.models.enums.Nationality
import com.randomuser.app.ui.mvi.ScreenViewModel
import com.randomuser.app.utils.KeeperKeys
import com.randomuser.app.utils.StateKeeper
import com.randomuser.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    reduce: UserInfoReduce,
    private val keeper: StateKeeper,
    private val userRepository: UserRepository
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
    ): Flow<UserInfoStore.Effect> = when(intent) {

        is UserInfoStore.Event.Close -> flow {
            sendSideEffect(UserInfoStore.SideEffect.Close)
        }
    }

    override fun handleEffect(
        currentState: UserInfoStore.State,
        effect: UserInfoStore.Effect,
    ): UserInfoStore.State {
        return when(effect) {

            is UserInfoStore.Effect.LoadUser ->
                currentState.copy(
                    UserUi(
                        userId = effect.user.localId,
                        firstName = effect.user.name.first,
                        lastName = effect.user.name.last,
                        phone = effect.user.phone,
                        nationality = Nationality.valueOf(effect.user.nat),
                        mediumPicture = effect.user.picture.medium
                    )
                )
        }
    }
}