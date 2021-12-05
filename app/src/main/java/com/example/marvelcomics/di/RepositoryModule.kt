package com.example.marvelcomics.di

import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.MarvelRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesRepository():MarvelRepository{
        return MarvelRepositoryImpl()
    }
}