package com.randomuser.app.di

import android.content.Context
import com.randomuser.app.utils.AppResource
import com.randomuser.app.utils.AppResourceImpl
import com.randomuser.app.utils.StateKeeper
import com.randomuser.app.utils.StateKeeperImpl
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
    fun provideStateKeeper(): StateKeeper {
        return StateKeeperImpl()
    }

    @ActivityRetainedScoped
    @Provides
    fun provideAppResource(@ApplicationContext context: Context): AppResource {
        return AppResourceImpl(context)
    }
}