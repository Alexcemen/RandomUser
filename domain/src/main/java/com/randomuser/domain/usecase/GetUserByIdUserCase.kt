package com.randomuser.domain.usecase

import com.randomuser.domain.repository.UserRepository
import com.randomuser.domain.utils.withIO
import javax.inject.Inject

class GetUserByIdUserCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(id: Int) = withIO {
        userRepository.getUserById(id)
    }
}