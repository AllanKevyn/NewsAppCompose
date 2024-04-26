package com.example.newsappcompose.di

import android.app.Application
import com.example.newsappcompose.data.manager.LocalUserManagerImpl
import com.example.newsappcompose.data.remote.NewsApi
import com.example.newsappcompose.data.repository.NewsRepositoryImpl
import com.example.newsappcompose.domain.manager.LocalUserManager
import com.example.newsappcompose.domain.repository.NewsRepository
import com.example.newsappcompose.domain.usecase.appentry.AppEntryUseCase
import com.example.newsappcompose.domain.usecase.appentry.ReadAppEntry
import com.example.newsappcompose.domain.usecase.appentry.SaveAppEntry
import com.example.newsappcompose.domain.usecase.news.GetNews
import com.example.newsappcompose.domain.usecase.news.NewsUseCase
import com.example.newsappcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(
        localUserManager: LocalUserManager
    ) = AppEntryUseCase(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideGetNewsUseCase(
        newsRepository: NewsRepository
    ): NewsUseCase {
        return NewsUseCase(
            getNews = GetNews(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

}