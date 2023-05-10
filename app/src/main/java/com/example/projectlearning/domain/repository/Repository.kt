package com.example.projectlearning.domain.repository

import com.example.projectlearning.domain.model.Person
import com.example.projectlearning.utils.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getPersons(page:Int): Flow<Resource<List<Person>>>

    fun getPerson(id:Int):Flow<Resource<com.example.projectlearning.domain.model.Character>>
    //suspend fun getPerson(id:Int):Person
}