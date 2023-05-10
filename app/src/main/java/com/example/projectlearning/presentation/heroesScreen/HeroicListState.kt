package com.example.projectlearning.presentation.heroesScreen

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.projectlearning.domain.model.Person

data class HeroicListState(
    val page: Int = 1,
    val endIsReached: Boolean = false,
    //val persons: List<Person> = listOf(),
    val persons: SnapshotStateList<Person> = SnapshotStateList(),//список из модели Person
    val isLoading: Boolean = false,
    val error: String = ""
)