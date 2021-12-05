package com.example.marvelcomics.domain.mapper

import com.example.marvelcomics.data.lacal.entity.CharactersEntity
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.domain.models.Character

class CharacterDtoToEntity : BaseMapper<CharactersDto, CharactersEntity> {
    override fun map(input: CharactersDto): CharactersEntity {
        return CharactersEntity(
            id = input.id?.toLong() ?: 0L,
            name = input.name.toString(),
            description = input.description.toString(),
            modified = input.modified.toString(),
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
        )
    }

}







//override fun map(input: CharactersDto): Character {
//    return Character(
//        id = input.id,
//        name = input.name,
//        imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
//        description = input.description
//    )
//}