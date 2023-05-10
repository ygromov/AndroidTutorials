package com.example.projectlearning.data.remote.dto

import com.example.projectlearning.domain.model.Person

data class PersonDto (
    val id:Int,
    val name:String,
    val status:String
)

data class Result(
    val results:List<PersonDto>
)

fun PersonDto.toPerson():Person{
    return Person(id = id, name = name,status = status)
}