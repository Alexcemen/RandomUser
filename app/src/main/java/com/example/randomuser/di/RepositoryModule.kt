package com.example.randomuser.di

import com.example.data.local.dao.UserDao
import com.example.data.mapper.UserMapper
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.UserRepository
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
        userMapper: UserMapper
    ): UserRepository {
        return UserRepositoryImpl(
            dao = userDao,
            mapper = userMapper
        )
    }
}