package com.example.projectlearning.data.remote

import com.example.projectlearning.data.remote.dto.CharacterDto
import com.example.projectlearning.data.remote.dto.PersonDto
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.projectlearning.data.remote.dto.Result
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.Path

interface Api {

    @GET("character/")
    suspend fun getPersons(
        @Query("page") page:Int //аннотация, с которой параметр обращается на сервер
    ):Result

    @GET("character/{id}")
    suspend fun getPerson(
        @Path("id") id:Int      // через @Path подставляем переданный id в @GET
    ):CharacterDto
    //):PersonDto

    @DELETE("character/{id}")
    suspend fun delPerson(
        @Path("id") id:Int
    )

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}


//object ApiSingleton {
//    val api = Retrofit.Builder()
//        .baseUrl(Api.BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(Api::class.java)
//}
