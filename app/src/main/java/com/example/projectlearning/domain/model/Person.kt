package com.example.projectlearning.domain.model

data class Person(
    val id: Int,
    val name: String,
    val status: String,
   // val origin:Origin
)

data class Origin(val name:String,val url:String)
