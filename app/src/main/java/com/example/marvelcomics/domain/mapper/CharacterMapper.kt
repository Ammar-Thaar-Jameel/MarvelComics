package com.example.marvelcomics.domain.mapper

import com.example.marvelcomics.data.lacal.entity.CharactersEntity
import com.example.marvelcomics.domain.models.Character

class CharacterMapper : Mapper<CharactersEntity, Character> {
    override fun map(input: CharactersEntity): Character {
        return Character(
            id = null,
            name = input.name,
            imageUrl = input.imageUrl,
            description = input.description
        )
    }

}

//override fun map(input: CharactersDto): Character {
//    return Character(
//        id = input.id,
//        name = input.name,
//        imageUrl = "${input.thumbnail?.path}.{${input.thumbnail?.extension}",
//        description = input.description
//    )
//}