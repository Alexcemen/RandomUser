package com.example.randomuser.di

import com.example.data.local.dao.UserDao
import com.example.data.mapper.DomainToEntityMapper
import com.example.data.mapper.DtoToDomainMapper
import com.example.data.mapper.EntityToDomainMapper
import com.example.data.remote.api.RandomUserApi
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        userDao: UserDao,
        dtoToDomain: DtoToDomainMapper,
        entityToDomain: EntityToDomainMapper,
        domainToEntity: DomainToEntityMapper,
        api: RandomUserApi
    ): UserRepository {
        return UserRepositoryImpl(
            dao = userDao,
            dtoToDomain = dtoToDomain,
            entityToDomain = entityToDomain,
            domainToEntity = domainToEntity,
            api = api
        )
    }
}