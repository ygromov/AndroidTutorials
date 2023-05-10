package com.example.projectlearning.presentation.heroesScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectlearning.data.repositoryImpl.RepositoryImpl
import com.example.projectlearning.domain.model.Person
import com.example.projectlearning.domain.repository.Repository
import com.example.projectlearning.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository:Repository
) : ViewModel() {

//    private lateinit var repository: Repository

    //val state by mutableStateOf(HeroicListState(emptyList()))
    var state by mutableStateOf(HeroicListState())


    init {
        //Log.d(TAG, "INIT: ")
//        repository = RepositoryImpl.getInstance()
        onEvent(HeroicEvent.GetPersons)
    }

    fun onEvent(event: HeroicEvent) {
        when (event) {
            is HeroicEvent.GetPersons -> {
                getPersons(state.page)
            }
            is HeroicEvent.DelPerson -> {
                delPerson(event.person)
            }
        }
    }

    private fun getPersons(page: Int) {
        viewModelScope.launch {
            repository.getPersons(page).collect{result->
                Log.d(TAG, "$state")
                when(result){
                    is Resource.Error -> {
                        state = state.copy(error = result.message!!)
                    }
                    is Resource.Loading ->{
                        state = state.copy(isLoading = result.isLoading)
                    }
                    is Resource.Success ->{
                        state.persons.addAll(result.data!!)
                        state = state.copy(page = state.page+1)
                    }
                }
            }
//            val persons = repository.getPersons(page)
//            if (persons.isNotEmpty()) {
//                state.persons.addAll(persons)
//                state = state.copy(page = state.page + 1)

//                val allPersons = state.persons.toMutableList()
//                allPersons.addAll(persons)
//                state = state.copy(persons = allPersons, page = state.page+1)
//            } else {
//                state = state.copy(endIsReached = true)
//            }
            //state.value = HeroicListState(persons)
            //var state by mutableStateOf(HeroicListState(persons))

            //Log.d(TAG, "getPersons: $persons")
        }
    }

    private fun delPerson(person: Person) {
        state.persons.remove(person)
//    state = state.copy()

    }
}