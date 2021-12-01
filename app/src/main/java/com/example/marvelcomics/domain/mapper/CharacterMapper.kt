package com.example.marvelcomics.domain.mapper

import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.domain.models.Character

class CharacterMapper : Mapper<CharactersDto, Character> {
    override fun map(input: CharactersDto): Character {
        return Character(
            id = input.id,
            name = input.name,
            imageUrl = "${input.thumbnail?.path}.{${input.thumbnail?.extension}",
            description = input.description
        )
    }
}