package com.example.marvelcomics.di

import androidx.paging.ExperimentalPagingApi
import com.example.marvelcomics.data.lacal.MarvelDataBase
import com.example.marvelcomics.data.remote.MarvelService
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.MarvelRepositoryImpl
import com.example.marvelcomics.domain.mapper.BaseMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers

@Module
@InstallIn(SingletonComponent::class)
@ExperimentalPagingApi
object RepositoryModule {

    @Provides
    fun providesRepository(
        apiService: MarvelService,
        dataBase: MarvelDataBase,
        baseMapper: BaseMapper
    ): MarvelRepository {
        return MarvelRepositoryImpl(
            apiService,
            dataBase,
            baseMapper

        )
    }


    @Provides
    fun provideMapper(): BaseMapper = Mappers.getMapper(BaseMapper::class.java)
}