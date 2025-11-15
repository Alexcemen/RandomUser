package com.randomuser.data.di

import android.content.Context
import com.randomuser.data.local.dao.UserDao
import com.randomuser.data.local.db.AppDatabase
import com.randomuser.data.local.db.createDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) =  createDatabase(context)

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()
}