package com.randomuser.domain.usecase

import com.randomuser.domain.repository.UserRepository

class GetSavedUsersUserCase(
    private val userRepository: UserRepository
) {
    operator fun invoke() = userRepository.getAllUsers()
}