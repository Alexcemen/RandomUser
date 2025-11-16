package com.randomuser.domain.usecase

import com.randomuser.domain.repository.UserRepository
import javax.inject.Inject

class GetSavedUsersUserCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke() = userRepository.getAllUsers()
}