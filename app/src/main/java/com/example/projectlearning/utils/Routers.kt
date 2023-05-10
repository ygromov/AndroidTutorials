package com.example.projectlearning.utils

sealed class Routers(val route: String){
    object MainScreen:Routers("MainScreen")
    object PersonScreen:Routers("PersonScreen")
    object TestScreen:Routers("TestScreen")
}
