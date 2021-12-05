package com.example.marvelcomics.domain.mapper

import com.example.marvelcomics.data.lacal.entity.CharactersEntity
import com.example.marvelcomics.domain.models.Character


class CharacterEntityToCharacter : BaseMapper<CharactersEntity, Character> {
    override fun map(input: CharactersEntity): Character {
        return Character(
            id = input.id,
            name = input.name,
            description = input.description,
            imageUrl = input.imageUrl,
        )
    }
}