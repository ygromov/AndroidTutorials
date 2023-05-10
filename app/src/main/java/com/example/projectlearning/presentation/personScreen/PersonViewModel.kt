package com.example.projectlearning.presentation.personScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
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

private const val TAG = "PersonViewModel"


@HiltViewModel
class PersonViewModel @Inject constructor(
    private val repository: Repository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var state by mutableStateOf(PersonState())
//    private lateinit var repository: Repository

    init {
//        repository = RepositoryImpl.getInstance()
        savedStateHandle.get<Int>("id")?.let {
            state = state.copy(id = it)
        }
        //getPerson()
        onEvent(PersonEvent.getPerson)
    }

    fun onEvent(event: PersonEvent) {
        when (event) {
            is PersonEvent.getPerson -> {
                getPerson()
            }
            is PersonEvent.delPerson -> {

            }
        }
    }

    private fun getPerson() {
        viewModelScope.launch {
            repository.getPerson(state.id).collect {
                when (it) {
                    is Resource.Error -> {
                        state = state.copy(error = it.message!!)
                    }
                    is Resource.Loading -> {
                        state = state.copy(isLoading = it.isLoading)
                    }
                    is Resource.Success -> {
                        state = it.data?.let { it1 ->
                            state.copy(
                                name = it1.name,
                                status = it.data.status,
                                species = it.data.species,
                                image = it.data.image
                            )
                        }!!
                    }
                }
            }

        }

//        viewModelScope.launch {
//           val result = repository.getPerson(state.id)
//            Log.d(TAG, "getPerson: $result")
//            state = state.copy(name = result.name, status = result.status, image = result.image, species = result.species)
//        }
    }

    private fun delPerson() {

    }
}