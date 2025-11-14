package com.example.data.repository

import com.example.data.local.dao.UserDao
import com.example.data.mapper.DomainToEntityMapper
import com.example.data.mapper.DtoToDomainMapper
import com.example.data.mapper.EntityToDomainMapper
import com.example.data.remote.api.RandomUserApi
import com.example.domain.repository.UserRepository
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dao: UserDao,
    private val dtoToDomain: DtoToDomainMapper,
    private val entityToDomain: EntityToDomainMapper,
    private val domainToEntity: DomainToEntityMapper,
    private val api: RandomUserApi,
) : UserRepository {

    override fun getAllUsers(): Flow<List<User>> {
        return dao.getAllUsers().map { list ->
            list.map { entityToDomain.map(it) }
        }
    }

    override suspend fun getUserById(id: Int): User? {
        return dao.getUserById(id)?.let { entityToDomain.map(it) }
    }

    override suspend fun insertUser(user: User) {
        dao.insertUser(domainToEntity.map(user))
    }

    override suspend fun insertUsers(users: List<User>) {
        dao.insertUsers(users.map { domainToEntity.map(it) })
    }

    override suspend fun clearUsers() {
        dao.clear()
    }

    override suspend fun fetchRandomUser(gender: String, nat: String): Result<User> {
        return try {
            val response = api.getRandomUser(gender, nat)
            val dto = response.results?.firstOrNull()
                ?: return Result.failure(Exception("API returned empty results"))
            val user = dtoToDomain.map(dto)
            return Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}