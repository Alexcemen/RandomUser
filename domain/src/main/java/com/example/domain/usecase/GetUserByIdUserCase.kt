package com.example.domain.usecase

import com.example.domain.model.User
import com.example.domain.repository.UserRepository

class GetUserByIdUserCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(id: Int): User? {
        return userRepository.getUserById(id)
    }
}