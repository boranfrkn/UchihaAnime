package com.boranfrkn.uchihanime.di

import com.boranfrkn.uchihanime.data.AnimeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    const val BASE_URL = "https://api.jikan.moe/"

    @Provides
    @Singleton
    fun provideRetrofit(
    ) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    }

    @Provides
    @Singleton
    fun provideHolidayAPI(retrofit: Retrofit): AnimeApi{
        return retrofit.create(AnimeApi::class.java)
    }
}