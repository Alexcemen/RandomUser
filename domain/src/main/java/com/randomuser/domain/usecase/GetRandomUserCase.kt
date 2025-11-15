package com.randomuser.domain.usecase

import com.randomuser.domain.model.User
import com.randomuser.domain.repository.UserRepository

class GetRandomUserCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(gender: String, nat: String): Result<User> {
        return userRepository.fetchRandomUser(gender, nat)
    }
}