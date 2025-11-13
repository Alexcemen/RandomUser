package com.example.domain

import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow


interface UserRepository {
    fun getAllUsers(): Flow<List<User>>
    suspend fun getUserById(id: Int): User?
    suspend fun insertUsers(users: List<User>)
    suspend fun clearUsers()
}