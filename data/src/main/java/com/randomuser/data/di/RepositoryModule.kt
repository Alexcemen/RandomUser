package com.randomuser.data.di

import com.randomuser.data.local.dao.UserDao
import com.randomuser.data.mapper.DomainToEntityMapper
import com.randomuser.data.mapper.DtoToDomainMapper
import com.randomuser.data.mapper.EntityToDomainMapper
import com.randomuser.data.remote.api.RandomUserApi
import com.randomuser.data.repository.UserRepositoryImpl
import com.randomuser.domain.repository.UserRepository
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