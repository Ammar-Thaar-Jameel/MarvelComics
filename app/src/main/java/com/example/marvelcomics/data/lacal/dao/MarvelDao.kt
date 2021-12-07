package com.example.marvelcomics.data.lacal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvelcomics.data.lacal.entity.CharacterSearchEntity
import com.example.marvelcomics.data.lacal.entity.CharactersEntity

@Dao
interface MarvelDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacters(items: List<CharactersEntity>)

    @Query("SELECT * FROM CharactersEntity")
    suspend fun getCharacters(): List<CharactersEntity>


    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSearchResult(items: List<CharacterSearchEntity>)

    @Query("SELECT * FROM CharacterSearchEntity")
    suspend fun getSearchResult():List<CharacterSearchEntity>
}