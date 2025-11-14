package com.example.domain.usecase

import com.example.domain.model.User
import com.example.domain.repository.UserRepository

class GetRandomUserCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(gender: String, nat: String): Result<User> {
        return userRepository.fetchRandomUser(gender, nat)
    }
}