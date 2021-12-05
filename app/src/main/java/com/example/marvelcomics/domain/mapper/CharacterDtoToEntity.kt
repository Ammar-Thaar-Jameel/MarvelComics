package com.example.marvelcomics.domain.mapper

import com.example.marvelcomics.data.lacal.entity.CharactersEntity
import com.example.marvelcomics.data.remote.response.CharactersDto
import javax.inject.Inject

class CharacterDtoToEntity @Inject constructor() : BaseMapper<CharactersDto, CharactersEntity> {
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
