package com.example.projectlearning.data.repositoryImpl

import com.example.projectlearning.data.remote.Api
import com.example.projectlearning.data.remote.dto.toCharacter
import com.example.projectlearning.data.remote.dto.toPerson
import com.example.projectlearning.domain.model.Person
import com.example.projectlearning.domain.repository.Repository

import com.example.projectlearning.domain.model.Character
import com.example.projectlearning.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//import com.example.projectlearning.data.remote.dto.toCharacter

class RepositoryImpl @Inject constructor(
    private val api: Api
    ) : Repository {
//    override suspend fun getPersons(page: Int): List<Person> {
//        val result = api.getPersons(page)
//        val list = result.results.map { personDto->
//            personDto.toPerson()
//        }
//        return list
//    }
//
//    override suspend fun getPerson(id: Int):Character {
//        val personCharacter = api.getPerson(id)
//        return personCharacter.toCharacter()
//    }

//    override suspend fun getPerson(id: Int):Person {
//        val personDto = api.getPerson(id)
//        return personDto.toPerson()
//    }

//    companion object {
//        @Volatile
//        private var INSTANCE: Repository? = null
//
//        fun getInstance(): Repository {
//            return INSTANCE ?: synchronized(this) {
//                INSTANCE ?: RepositoryImpl(ApiSingleton.api).also {
//                    INSTANCE = it
//                }
//            }
//        }
//    }

    override fun getPersons(page: Int): Flow<Resource<List<Person>>> = flow {
        emit(Resource.Loading())
        delay(1500)
        try {
            val result = api.getPersons(page)
            val list = result.results.map { personDto ->
                personDto.toPerson()
            }
            emit(Resource.Success(data = list))
        } catch (ex: Exception) {
            emit(Resource.Error(message = "Error"))
        }
        emit(Resource.Loading(isLoading = false))
    }

    override fun getPerson(id: Int): Flow<Resource<Character>> = flow {
        emit(Resource.Loading())
        try {
            val personCharacter = api.getPerson(id)
            val person=  personCharacter.toCharacter()
            emit(Resource.Success(data = person))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Error"))
        }
        emit(Resource.Loading(isLoading = false))
    }
}