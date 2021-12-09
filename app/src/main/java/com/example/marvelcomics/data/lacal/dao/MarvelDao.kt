package com.example.marvelcomics.data.lacal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvelcomics.data.lacal.entity.CharacterSearchEntity
import com.example.marvelcomics.data.lacal.entity.CharactersEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacters(items: List<CharactersEntity>)

    @Query("SELECT * FROM CharactersEntity")
    fun getCharacters(): Flow<List<CharactersEntity>>


    @Insert
    suspend fun addSearchResult(items: List<CharacterSearchEntity>)

    @Query("SELECT * FROM CharacterSearchEntity")
    fun getSearchResult(): Flow<List<CharacterSearchEntity>>
}