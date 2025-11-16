package com.randomuser.domain.usecase

import com.randomuser.domain.repository.UserRepository

class ClearUsersUserCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userId: Int) {
        userRepository.deleteUser(userId)
    }
}