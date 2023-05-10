package com.example.projectlearning.presentation.heroesScreen

import com.example.projectlearning.domain.model.Person

sealed class HeroicEvent{
    object GetPersons:HeroicEvent()
    data class DelPerson(val person: Person):HeroicEvent()
}

