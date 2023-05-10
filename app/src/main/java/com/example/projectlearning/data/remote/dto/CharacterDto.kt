package com.example.projectlearning.data.remote.dto

import com.example.projectlearning.domain.model.Character
//import com.example.projectlearning.domain.model.

data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val image: String,
    val species: String
)

data class Result1(
    val results: List<CharacterDto>
)

fun CharacterDto.toCharacter():Character{
    return Character(id = id, name = name, status = status, image = image, species = species)
}