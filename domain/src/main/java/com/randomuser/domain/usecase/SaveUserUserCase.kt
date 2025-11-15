package com.randomuser.domain.usecase

import com.randomuser.domain.model.User
import com.randomuser.domain.repository.UserRepository

class SaveUserUserCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User) {
        userRepository.insertUser(user)
    }
}