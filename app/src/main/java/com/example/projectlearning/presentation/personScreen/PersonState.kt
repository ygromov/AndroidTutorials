package com.example.projectlearning.presentation.personScreen

import com.example.projectlearning.domain.model.Person
import java.util.Objects


data class PersonState(
    val id:Int = -1,
    val name: String="",
    val status:String="",
    val image:String ="",
    val species:String="",
    val error:String = "",
    val isLoading:Boolean=false
    //val personOne: Person = Person(id=id, name=name,status=status)
)