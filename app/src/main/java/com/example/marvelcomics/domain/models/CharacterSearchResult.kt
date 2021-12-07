package com.example.marvelcomics.domain.models

data class CharacterSearchResult(

    var id: Long?,
    var name: String?,
    var imageUrlPath: String?,
    var modified:String,
    var description:String?,
    var imageUrlExtension:String
)
