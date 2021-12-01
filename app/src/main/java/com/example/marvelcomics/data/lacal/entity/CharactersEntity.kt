package com.example.marvelcomics.data.lacal.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharactersEntity(
    @PrimaryKey
    var id:Long,
    val name:String,
//    val description:String,
//    val modified:String,
//    val imageUrl:String

)
