package com.randomuser.app.ui.screen.user_info

import androidx.lifecycle.viewModelScope
import com.randomuser.app.ui.mvi.ScreenViewModel
import com.randomuser.app.utils.KeeperKeys
import com.randomuser.app.utils.StateKeeper
import com.randomuser.app.utils.mapUserToUserInfoUi
import com.randomuser.domain.usecase.GetUserByIdUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserInfoViewModel @Inject constructor(
    reduce: UserInfoReduce,
    private val keeper: StateKeeper,
    private val getUserByIdUseCase: GetUserByIdUserCase
) : ScreenViewModel<UserInfoStore.State, UserInfoStore.Event, UserInfoStore.SideEffect, UserInfoStore.Effect, UserInfoStore.UiState>(
    reduce
) {
    init {
        viewModelScope.launch {
            val userId = keeper.getInt(KeeperKeys.USER_ID_BUNDLE) ?: return@launch
            val user = getUserByIdUseCase(userId) ?: return@launch
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
                    user = mapUserToUserInfoUi(effect.user)
                )

            is UserInfoStore.Effect.OnTabClick ->
                currentState.copy(
                    selectedUserInfoTab = effect.userInfoTab
                )
        }
    }
}




