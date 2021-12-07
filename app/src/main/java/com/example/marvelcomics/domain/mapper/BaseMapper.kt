package com.example.marvelcomics.domain.mapper

import com.example.marvelcomics.data.lacal.entity.CharactersEntity
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.domain.models.Character
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface BaseMapper {

    // fun map(input: Input): Output

    @Mapping(source = "thumbnail.path", target = "imageUrlPath")
    @Mapping(source = "thumbnail.extension", target = "imageUrlExtension")
    fun mapCharacterDtoToEntity(charactersDto: CharactersDto): CharactersEntity


    @Mapping(source = "imageUrlPath", target = "imageUrlPath")
    @Mapping(source = "imageUrlExtension", target = "imageUrlExtension")
    fun mapCharacterEntityToCharacterDomain(charactersEntity: CharactersEntity): Character


}