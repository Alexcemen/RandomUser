package com.example.randomuser.di

import android.content.Context
import com.example.randomuser.utils.AppResource
import com.example.randomuser.utils.AppResourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class AppModule {

    @ActivityRetainedScoped
    @Provides
    fun provideAppResource(@ApplicationContext context: Context): AppResource {
        return AppResourceImpl(context)
    }
}