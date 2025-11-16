package com.randomuser.domain.usecase

import com.randomuser.domain.repository.UserRepository
import com.randomuser.domain.utils.withIO
import javax.inject.Inject

class DeleteUserUserCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userId: Int) = withIO{
        userRepository.deleteUser(userId)
    }
}