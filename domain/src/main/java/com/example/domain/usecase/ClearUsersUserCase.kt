package com.example.domain.usecase

import com.example.domain.repository.UserRepository

class ClearUsersUserCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() {
        userRepository.clearUsers()
    }
}