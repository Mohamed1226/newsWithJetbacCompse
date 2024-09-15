package com.loc.newsapp.core.di

import android.app.Application
import com.loc.newsapp.core.constants.UserSettings.BASE_URL
import com.loc.newsapp.core.repository.NewsRepository

import com.loc.newsapp.core.usecases.app_entry_use_cases.AppEntryUseCases
import com.loc.newsapp.core.usecases.app_entry_use_cases.GetAppEntryUseCases
import com.loc.newsapp.core.usecases.app_entry_use_cases.SaveAppEntryUseCases
import com.loc.newsapp.core.usecases.news_screen.NewsUseCases
import com.loc.newsapp.core.usecases.news_screen.UsedNewsUseCase
import com.loc.newsapp.data.app_manager.AppMangerImpl
import com.loc.newsapp.data.news_api.dto.remote_data_source.NewsApi
import com.loc.newsapp.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserSetting(application: Application): AppMangerImpl =
        AppMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(localUserSetting: AppMangerImpl) = AppEntryUseCases(
        getUserSettingUseCases = GetAppEntryUseCases(localUserSetting),
        saveUserSettingUseCases = SaveAppEntryUseCases(localUserSetting)
    )

    @Provides
    @Singleton
    fun provideNewsApi() = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        .create(NewsApi::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository =
        NewsRepositoryImpl(newsApi = newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCase(newsRepository: NewsRepository) = UsedNewsUseCase(
        newsUseCases = NewsUseCases(newsRepository)
    )
}