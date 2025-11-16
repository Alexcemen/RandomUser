package com.randomuser.domain.usecase

import com.randomuser.domain.repository.UserRepository
import com.randomuser.domain.utils.withIO
import javax.inject.Inject

class GetRandomUserCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(gender: String, nat: String) = withIO {
        userRepository.fetchRandomUser(gender, nat)
    }
}