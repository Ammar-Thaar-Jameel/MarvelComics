package com.example.marvelcomics.data.lacal.Daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvelcomics.data.lacal.entity.CharactersEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface MarvelDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacters(items: List<CharactersEntity>)

    @Query("SELECT * FROM CharactersEntity")
    fun getCharacters(): Flow<List<CharactersEntity>>
}