package com.example.projectlearning.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.projectlearning.domain.model.Person
import com.example.projectlearning.presentation.HeroesScreen
import com.example.projectlearning.presentation.heroesScreen.MainViewModel
import com.example.projectlearning.presentation.personScreen.PersonScreen
import com.example.projectlearning.presentation.personScreen.PersonState
import com.example.projectlearning.presentation.personScreen.PersonViewModel
import com.example.projectlearning.utils.Routers

@Composable
fun Navigtion(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Routers.MainScreen.route) {

        composable(route = Routers.MainScreen.route) {
            val viewmodel: MainViewModel = hiltViewModel()
            HeroesScreen(
                heroicListState = viewmodel.state,
                //HeroicEvent = viewmodel::onTriggerEvent,
                navController = navHostController,
                onEvent = viewmodel::onEvent
            )
        }

        composable(Routers.PersonScreen.route + "/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                }
            )
        ) {
            val viewmodel: PersonViewModel = hiltViewModel()
            PersonScreen(
                navController = navHostController,
                personState = viewmodel.state,
                person = viewmodel.state
            )
        }
        composable(Routers.TestScreen.route + "/{id}",
//            arguments = listOf(
//                navArgument(name = "id") {
//                    type = NavType.IntType
//                }
//            )
        ) {
//            val viewmodel: PersonViewModel = viewModel()
//            PersonScreen(
//                navController = navHostController,
//                personState = viewmodel.state,
//                person = viewmodel.state
//            )
        }
    }
}