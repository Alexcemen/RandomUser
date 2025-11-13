package com.example.randomuser.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.dao.UserDao
import com.example.data.local.db.AppDatabase
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
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "randomuser-db"
        ).fallbackToDestructiveMigration(true)
            .build()
    }

    @Provides
    fun provideUserDao(
        db: AppDatabase
    ): UserDao = db.userDao()
}