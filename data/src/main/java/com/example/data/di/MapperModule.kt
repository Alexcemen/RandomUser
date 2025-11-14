package com.example.data.di

import com.example.data.mapper.DomainToEntityMapper
import com.example.data.mapper.DtoToDomainMapper
import com.example.data.mapper.DtoToEntityMapper
import com.example.data.mapper.EntityToDomainMapper
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