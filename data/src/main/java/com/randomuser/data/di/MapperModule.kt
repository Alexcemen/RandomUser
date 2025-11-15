package com.randomuser.data.di

import com.randomuser.data.mapper.DomainToEntityMapper
import com.randomuser.data.mapper.DtoToDomainMapper
import com.randomuser.data.mapper.DtoToEntityMapper
import com.randomuser.data.mapper.EntityToDomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideDtoToDomainMapper(): DtoToDomainMapper = DtoToDomainMapper()

    @Provides
    @Singleton
    fun provideDtoToEntityMapper(): DtoToEntityMapper = DtoToEntityMapper()

    @Provides
    @Singleton
    fun provideEntityToDomainMapper(): EntityToDomainMapper = EntityToDomainMapper()

    @Provides
    @Singleton
    fun provideDomainToEntityMapper(): DomainToEntityMapper = DomainToEntityMapper()
}