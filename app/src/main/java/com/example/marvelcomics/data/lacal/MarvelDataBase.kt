package com.example.marvelcomics.data.lacal

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvelcomics.data.lacal.Daos.MarvelDao
import com.example.marvelcomics.data.lacal.entity.CharactersEntity


@Database(entities = [CharactersEntity::class], version = 1)
abstract class MarvelDataBase : RoomDatabase() {

    abstract fun marvelCharactersDao(): MarvelDao


    companion object {
        const val DB_NAME = "DB_MARVEL"

    }
}