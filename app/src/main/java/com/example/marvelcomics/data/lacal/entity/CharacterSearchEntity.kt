package com.example.marvelcomics.data.lacal.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class CharacterSearchEntity(
    @PrimaryKey
    var id: Long,
    var name: String,
    var description: String,
    var modified: String,
    var imageUrlPath: String,
    var imageUrlExtension: String

)
