package com.example.marvelcomics.data.lacal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marvelcomics.data.lacal.Daos.MarvelDao
import com.example.marvelcomics.data.lacal.entity.CharactersEntity


@Database(entities = [CharactersEntity::class], version = 1)
abstract class MarvelDataBase : RoomDatabase() {

    abstract fun marvelCharactersDao():MarvelDao


    companion object {
        private const val DB_NAME = "DB_MARVEL"

        @Volatile
        private var instance: MarvelDataBase? = null

        private fun buildDatabase(context: Context): MarvelDataBase {
            return Room.databaseBuilder(context, MarvelDataBase::class.java, DB_NAME).build()
        }

        fun getInstance(context: Context): MarvelDataBase {
            return instance ?: synchronized(this) { buildDatabase(context).also { instance = it } }
        }

        val getInstance get() = instance!!
    }
}