package com.example.domain.usecase

import com.example.domain.repository.UserRepository

class GetSavedUsersUserCase(
    private val userRepository: UserRepository
) {
    operator fun invoke() = userRepository.getAllUsers()
}