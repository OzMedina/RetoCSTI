package com.oscar.retocsti.navigation.di

import com.oscar.retocsti.navigation.NavigationManager
import com.oscar.retocsti.navigation.NavigationManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {
    @Provides
    fun provideNavigationManager(): NavigationManager = NavigationManagerImpl
}
