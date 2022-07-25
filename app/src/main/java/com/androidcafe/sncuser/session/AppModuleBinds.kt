package com.androidcafe.sncuser.session

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleBinds {
    @Singleton
    @Binds
    abstract fun provideSessionManager(impl: SessionManagerImpl): SessionManager
}