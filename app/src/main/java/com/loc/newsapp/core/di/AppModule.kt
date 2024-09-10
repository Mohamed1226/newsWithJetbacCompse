package com.loc.newsapp.core.di

import android.app.Application

import com.loc.newsapp.core.usecases.app_entry_use_cases.AppEntryUseCases
import com.loc.newsapp.core.usecases.app_entry_use_cases.GetAppEntryUseCases
import com.loc.newsapp.core.usecases.app_entry_use_cases.SaveAppEntryUseCases
import com.loc.newsapp.data.app_manager.AppMangerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserSetting(application: Application) : AppMangerImpl = AppMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(localUserSetting: AppMangerImpl) = AppEntryUseCases(
        getUserSettingUseCases = GetAppEntryUseCases(localUserSetting),
        saveUserSettingUseCases = SaveAppEntryUseCases(localUserSetting)
    )
}