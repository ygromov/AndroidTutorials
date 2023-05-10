package com.example.projectlearning.di

import com.example.projectlearning.data.remote.Api
import com.example.projectlearning.data.remote.Api.Companion.BASE_URL
import com.example.projectlearning.data.repositoryImpl.RepositoryImpl
import com.example.projectlearning.domain.repository.Repository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(gsonBuilder: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    }

    @Singleton
    @Provides
    fun provideApiService(retrofitBuilder: Retrofit.Builder): Api {
        return retrofitBuilder
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        api: Api
    ): Repository {
        return RepositoryImpl(api)
    }
}