package com.example.projectlearning.presentation.personScreen

sealed class PersonEvent{
    object getPerson:PersonEvent()
    object delPerson:PersonEvent()
}
