package com.example.marvelcomics.di

import com.example.marvelcomics.data.remote.MarvelService
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.MarvelRepositoryImpl
import com.example.marvelcomics.domain.mapper.CharacterDtoToEntity
import com.example.marvelcomics.domain.mapper.CharacterEntityToCharacter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesRepository(
        apiService: MarvelService,
        characterDtoToEntity: CharacterDtoToEntity,
        characterEntityToCharacter: CharacterEntityToCharacter
    ): MarvelRepository {
        return MarvelRepositoryImpl(apiService, characterDtoToEntity, characterEntityToCharacter)
    }
}