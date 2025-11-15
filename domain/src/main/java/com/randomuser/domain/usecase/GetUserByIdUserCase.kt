package com.randomuser.domain.usecase

import com.randomuser.domain.model.User
import com.randomuser.domain.repository.UserRepository

class GetUserByIdUserCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(id: Int): User? {
        return userRepository.getUserById(id)
    }
}