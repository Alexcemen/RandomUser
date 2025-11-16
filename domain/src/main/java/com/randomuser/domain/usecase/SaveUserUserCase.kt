package com.randomuser.domain.usecase

import com.randomuser.domain.model.User
import com.randomuser.domain.repository.UserRepository
import com.randomuser.domain.utils.withIO
import javax.inject.Inject

class SaveUserUserCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User) = withIO {
        userRepository.insertUser(user)
    }
}