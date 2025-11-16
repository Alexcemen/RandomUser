package com.randomuser.domain.repository

import com.randomuser.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAllUsers(): Flow<List<User>>
    suspend fun getUserById(userid: Int): User?
    suspend fun insertUser(user: User)
    suspend fun insertUsers(users: List<User>)
    suspend fun deleteUser(userId: Int)
    suspend fun fetchRandomUser(gender: String, nat: String): Result<User>
}