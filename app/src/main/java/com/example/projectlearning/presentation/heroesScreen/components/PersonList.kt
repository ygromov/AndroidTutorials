package com.example.projectlearning.presentation.heroesScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.projectlearning.domain.model.Person
import com.example.projectlearning.presentation.heroesScreen.HeroicEvent

@Composable
fun PersonItem(
    endIsReached: Boolean,
    persons: List<Person>,
    onClick: (id: Int) -> Unit,
    onEvent: (HeroicEvent) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        itemsIndexed(persons) { index, person ->
            if (index >= persons.size - 1 && !endIsReached) {
                onEvent.invoke(HeroicEvent.GetPersons)

            }
            PersonCard(
                person = person,
                onClick = onClick,
                onEvent = onEvent
                //onEvent1 = onEvent
                //onEvent=onEvent
            )
        }
    }
}

