package com.example.data.repository

import com.example.data.local.dao.UserDao
import com.example.data.mapper.UserMapper
import com.example.domain.UserRepository
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dao: UserDao,
    private val mapper: UserMapper
) : UserRepository {

    override fun getAllUsers(): Flow<List<User>> {
        return dao.getAllUsers().map { list ->
            list.map { mapper.entityToDomain(it) }
        }
    }

    override suspend fun getUserById(id: Int): User? {
        return dao.getUserById(id)?.let { mapper.entityToDomain(it) }
    }

    override suspend fun insertUsers(users: List<User>) {
        dao.insertUsers(users.map { mapper.domainToEntity(it) })
    }

    override suspend fun clearUsers() {
        dao.clear()
    }
}