package com.randomuser.app.ui.screen.create_user

import com.randomuser.app.ui.mvi.ScreenViewModel
import com.randomuser.domain.repository.UserRepository
import com.randomuser.domain.usecase.GetRandomUserCase
import com.randomuser.domain.usecase.SaveUserUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class CreateUserViewModel @Inject constructor(
    reduce: CreateUserReduce,
    private val userRepository: UserRepository,
    private val getRandomUserUseCase: GetRandomUserCase,
    private val saveUserUseCase: SaveUserUserCase
) : ScreenViewModel<CreateUserStore.State, CreateUserStore.Event, CreateUserStore.SideEffect, CreateUserStore.Effect, CreateUserStore.UiState>(
    reduce
) {
    override fun createState(): CreateUserStore.State = CreateUserStore.State()


    override fun handleEvent(
        currentState: CreateUserStore.State,
        intent: CreateUserStore.Event,
    ): Flow<CreateUserStore.Effect> = when (intent) {

        CreateUserStore.Event.Close -> flow {
            sendSideEffect(CreateUserStore.SideEffect.Close)
        }

        is CreateUserStore.Event.Generate -> flow {
            emit(CreateUserStore.Effect.LoadingStarted)

            //TODO
//            val result = withIO {
//                userRepository.fetchRandomUser(
//                    gender = currentState.gender.name,
//                    nat = currentState.nationality.name
//                )
//            }

            val result = getRandomUserUseCase(
                gender = currentState.gender.name,
                nat = currentState.nationality.name
            )

            //TODO
            result.onSuccess { user ->
//                withIO {
//                    userRepository.insertUser(user)
//                }
                saveUserUseCase(user)


                emit(CreateUserStore.Effect.LoadingFinished)
                sendSideEffect(CreateUserStore.SideEffect.Close)
                sendSideEffect(
                    CreateUserStore.SideEffect.ShowToast(
                        msg = "Новый пользователь ${user.name.title} ${user.name.first} ${user.name.last} успешно добавлен в список"
                    )
                )
            }
            result.onFailure { error ->
                emit(CreateUserStore.Effect.LoadingFinished)
                sendSideEffect(
                    CreateUserStore.SideEffect.ShowToast(
                        msg = "Не удалось добавить нового пользователя"
                    )
                )
            }
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
        return when (effect) {

            is CreateUserStore.Effect.SelectedGender -> currentState.copy(gender = effect.gender)

            is CreateUserStore.Effect.SelectedNationality -> currentState.copy(nationality = effect.nationality)

            is CreateUserStore.Effect.LoadingStarted -> currentState.copy(isLoading = true)

            is CreateUserStore.Effect.LoadingFinished -> currentState.copy(isLoading = false)

        }
    }
}