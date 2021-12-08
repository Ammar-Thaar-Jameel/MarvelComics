package com.example.marvelcomics.domain.mapper

import com.example.marvelcomics.data.lacal.entity.CharacterSearchEntity
import com.example.marvelcomics.data.lacal.entity.CharactersEntity
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.domain.models.CharacterSearchResult
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface BaseMapper {


    @Mapping(source = "thumbnail.path", target = "imageUrlPath")
    @Mapping(source = "thumbnail.extension", target = "imageUrlExtension")
    fun mapCharacterDtoToEntity(charactersDto: CharactersDto): CharactersEntity


    @Mapping(source = "imageUrlPath", target = "imageUrlPath")
    @Mapping(source = "imageUrlExtension", target = "imageUrlExtension")
    fun mapCharacterEntityToCharacterDomain(charactersEntity: CharactersEntity): Character

    @Mapping(source = "thumbnail.path", target = "imageUrlPath")
    @Mapping(source = "thumbnail.extension", target = "imageUrlExtension")
    fun mapCharacterDtoSearchToEntity(charactersDto: CharactersDto): CharacterSearchEntity

    @Mapping(source = "imageUrlPath", target = "imageUrlPath")
    @Mapping(source = "imageUrlExtension", target = "imageUrlExtension")
    fun mapCharacterSearchEntityToCharacterDomain(characterSearchEntity: CharacterSearchEntity): CharacterSearchResult


    @Mapping(source = "thumbnail.path", target = "imageUrlPath")
    @Mapping(source = "thumbnail.extension", target = "imageUrlExtension")
    fun mapCharacterDtoToCharacterDomain(charactersDto: CharactersDto):Character
}