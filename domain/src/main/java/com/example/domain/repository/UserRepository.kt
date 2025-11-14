package com.example.domain.repository

import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAllUsers(): Flow<List<User>>
    suspend fun getUserById(id: Int): User?
    suspend fun insertUser(user: User)
    suspend fun insertUsers(users: List<User>)
    suspend fun clearUsers()
    suspend fun fetchRandomUser(gender: String, nat: String): Result<User>
}