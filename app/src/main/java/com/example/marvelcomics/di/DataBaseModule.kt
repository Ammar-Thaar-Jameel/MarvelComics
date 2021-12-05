package com.example.marvelcomics.di

import android.content.Context
import androidx.room.Room
import com.example.marvelcomics.data.lacal.Daos.MarvelDao
import com.example.marvelcomics.data.lacal.MarvelDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideMarvelDatabase(@ApplicationContext context: Context): MarvelDataBase {
        return Room.databaseBuilder(
            context,
            MarvelDataBase::class.java,
            MarvelDataBase.DB_NAME
        )
            .build()
    }

    @Singleton
    @Provides
    fun provideCharactersDao(marvelDataBase: MarvelDataBase): MarvelDao {
        return marvelDataBase.marvelCharactersDao()

    }

}
